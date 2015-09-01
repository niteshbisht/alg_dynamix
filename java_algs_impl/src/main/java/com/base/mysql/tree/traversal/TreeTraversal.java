package com.base.mysql.tree.traversal;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class TreeTraversal {

	Logger lgr = Logger.getLogger("TreeTraversal");
	java.sql.Connection con;
	java.sql.Statement statement;

	public static void main(String[] args) {
		TreeTraversal treeTrav = new TreeTraversal();
		treeTrav.getData();
	}

	public void getDataJsonFromResultSet(ResultSet rs) throws SQLException {
		String currentLevelName;
		TreeStructure rootNode = new TreeStructure();
		rootNode.setLevelIndex(0);
		TreeStructure childNode;
		String parentLevelName;
		int i = 1;
		while (rs.next()) {
			i = 1;
			while (i <= 7) {
				currentLevelName = rs.getString(i);
				boolean present = searchRecordInTree(rootNode,
						currentLevelName, i);
				if (!present) {
					if (i == 1)
						parentLevelName = null;
					else
						parentLevelName = rs.getString(i - 1);
					childNode = createTreeNode(i, currentLevelName);
					putdataInTree(rootNode, childNode, currentLevelName,
							parentLevelName, i);
				}
				i++;
			}
		}
		ObjectMapper om = new ObjectMapper();
		try {
			String s = om.writeValueAsString(rootNode);
			System.out.println(s);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void putdataInTree(TreeStructure rootNode, TreeStructure childNode,
			String currentLevelName, String parentLevelName, int levelIndex) {
		if (parentLevelName == null) {
			putDataInRootNode(rootNode, childNode, currentLevelName, levelIndex);
		} else {
			Map<String, List<TreeStructure>> tsListMap = rootNode
					.getChildNodes();
			if (tsListMap.containsKey(parentLevelName)) {
				List<TreeStructure> tsListItems = tsListMap
						.get(parentLevelName);
				for(int i = 0;i<tsListItems.size();i++){
					TreeStructure ts = tsListItems.get(i);
					if(ts.getLevelName().equals(parentLevelName) && ts.getLevelIndex()==levelIndex-1){
						Map<String, List<TreeStructure>> tsChild = ts.getChildNodes();
						List<TreeStructure> addList = new ArrayList<TreeStructure>();
						addList.add(childNode);
						tsChild.put(currentLevelName, addList);
					}
				}
			}else{
				Iterator<String> itr = tsListMap.keySet().iterator();
				while (itr.hasNext()) {
					List<TreeStructure> tsl = tsListMap.get(itr.next());
					for(int i = 0;i<tsl.size();i++){
						TreeStructure ts = tsl.get(i);
						if(ts.getLevelName().equals(parentLevelName) && ts.getLevelIndex()==levelIndex-1){
							Map<String, List<TreeStructure>> tsChild = ts.getChildNodes();
							List<TreeStructure> addList = new ArrayList<TreeStructure>();
							addList.add(childNode);
							tsChild.put(currentLevelName, addList);
						}else{
							putdataInTree(ts, childNode, currentLevelName, parentLevelName, levelIndex);
						}
					}
				}
			}
		}
	}

	public void putDataInRootNode(TreeStructure rootNode,
			TreeStructure childNode, String currentLevelName, int levelIndex) {
		List<TreeStructure> tsList = new ArrayList<TreeStructure>();
		tsList.add(childNode);
		rootNode.getChildNodes().putIfAbsent(currentLevelName, tsList);
	}

	public TreeStructure createTreeNode(int levelIndex, String levelName) {
		TreeStructure ts = new TreeStructure();
		ts.setLevelIndex(levelIndex);
		ts.setLevelName(levelName);
		return ts;
	}

	@SuppressWarnings("unused")
	public boolean searchRecordInTree(TreeStructure root, String levelName,
			int levelIndex) {
		if (root.getLevelIndex() == levelIndex
				&& root.getLevelName().equals(levelName)) {
			return true;
		} else {
			Map<String, List<TreeStructure>> ts = root.getChildNodes();
			Iterator<String> itr = ts.keySet().iterator();
			boolean localResult;
			while (itr.hasNext()) {
				List<TreeStructure> tsList = ts.get(itr.next());
				for (int i = 0; i < tsList.size(); ++i) {
					TreeStructure tempTsRoot = tsList.get(i);
					localResult = searchRecordInTree(tempTsRoot, levelName,
							levelIndex);
					if (localResult)
						return true;
				}
			}
		}
		return false;
	}

	public TreeStructure getTreeNode(String levelName, int levelIndex) {
		TreeStructure ts = new TreeStructure();
		ts.setLevelIndex(levelIndex);
		ts.setLevelName(levelName);
		return ts;
	}

	public void getData() {
		try {
			lgr.info("Here is inside");
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager
					.getConnection("jdbc:mysql://localhost/sqlpract?"
							+ "user=root&password=welcome");
			statement = con.createStatement();
			ResultSet rs = statement
					.executeQuery("select * from sqlpract.tree");
			getDataJsonFromResultSet(rs);
		} catch (Exception e) {
			lgr.info("exception here " + e.getStackTrace());
			lgr.info("exception line 2 " + e.getMessage());
			lgr.info("exception line 3 " + e.getCause());
		} finally {
		}
	}
}
