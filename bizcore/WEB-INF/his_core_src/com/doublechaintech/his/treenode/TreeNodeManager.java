
package com.doublechaintech.his.treenode;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.his.HisUserContext;
import com.doublechaintech.his.BaseEntity;
import com.doublechaintech.his.BaseManager;
import com.doublechaintech.his.SmartList;

public interface TreeNodeManager extends BaseManager{

		

	public TreeNode createTreeNode(HisUserContext userContext, String nodeId,String nodeType,int leftValue,int rightValue) throws Exception;
	public TreeNode updateTreeNode(HisUserContext userContext,String treeNodeId, int treeNodeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public TreeNode loadTreeNode(HisUserContext userContext, String treeNodeId, String [] tokensExpr) throws Exception;
	public TreeNode internalSaveTreeNode(HisUserContext userContext, TreeNode treeNode) throws Exception;
	public TreeNode internalSaveTreeNode(HisUserContext userContext, TreeNode treeNode,Map<String,Object>option) throws Exception;



	public void delete(HisUserContext userContext, String treeNodeId, int version) throws Exception;
	public int deleteAll(HisUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(HisUserContext userContext, TreeNode newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/




}





















