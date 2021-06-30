package nexbank.xyz.ordins.biz;

import java.util.Map;

import nexcore.framework.core.component.streotype.BizAttribute;
import nexcore.framework.core.component.streotype.BizMethod;
import nexcore.framework.core.component.streotype.BizUnit;
import nexcore.framework.core.data.DataSet;
import nexcore.framework.core.data.IDataSet;
import nexcore.framework.core.data.IOnlineContext;
import nexcore.framework.core.data.IRecord;
import nexcore.framework.core.data.IRecordSet;
import nexcore.framework.core.exception.BizRuntimeException;
import nexcore.framework.core.log.ILog;

/**
 * null.
 * <pre>
 * 상시감사 수신후 조건 만족하는 경우 저장 
 * </pre>
 * 
 * @author admin (Administrator)
 * @since 2021-06-30 18:42:18
 */
@BizUnit(value = "상시감사이력", type = "DU")
public class DTB_CBS_XYZ_ORDINS_IN_H_00 extends nexcore.framework.biz.online.DataUnit {

	/**
	 * tb_cbs_xyz_ordins_in_h SELECT.
	 * <pre>
	 * tb_cbs_xyz_ordins_in_h SELECT
	 * </pre>
	 * @param requestData 요청정보 DataSet 객체
	 * <pre>
	 *	- field : TX_TYPE [TX_TYPE] (string)
	 *	- field : ACC_NO_1 [ACC_NO_1] (string)
	 *	- field : AMOUNT_1 [AMOUNT_1] (string)
	 *	- field : ACC_NO_2 [ACC_NO_2] (string)
	 *	- field : AMOUNT_2 [AMOUNT_2] (string)
	 *	- field : NOTES [NOTES] (string)
	 *	- field : STATUS [STATUS] (string)
	 *	- field : CRE_DTM [CRE_DTM] (string)
	 *	- field : UPD_DTM [UPD_DTM] (string)
	 * </pre>
	 * @param onlineCtx 요청 컨텍스트 정보
	 * @return 처리결과 DataSet 객체
	 * <pre>
	 *	- field : TX_TYPE [TX_TYPE] (string)
	 *	- field : ACC_NO_1 [ACC_NO_1] (string)
	 *	- field : AMOUNT_1 [AMOUNT_1] (string)
	 *	- field : ACC_NO_2 [ACC_NO_2] (string)
	 *	- field : AMOUNT_2 [AMOUNT_2] (string)
	 *	- field : NOTES [NOTES] (string)
	 *	- field : STATUS [STATUS] (string)
	 *	- field : CRE_DTM [CRE_DTM] (string)
	 *	- field : UPD_DTM [UPD_DTM] (string)
	 * </pre>
	 * 
	 * @author admin (Administrator)
	 * @since 2021-06-30 18:07:03
	 */
	@BizMethod("tb_cbs_xyz_ordins_in_h SELECT")
	public IDataSet s001(IDataSet requestData, IOnlineContext onlineCtx) {
	    IDataSet responseData = new DataSet();
	    
	    // Auto-generated execute db block
	    IRecord record = dbSelectSingle("S001", requestData, onlineCtx);
	    
	    // Auto-generated make response block
	    if (record != null){
	        responseData.putAll(record);
	    }
	    
	    // 처리 결과값을 responseData에 넣어서 리턴하십시요 
	
	    return responseData;
	}

	/**
	 * tb_cbs_xyz_ordins_in_h SELECT ALL.
	 * <pre>
	 * tb_cbs_xyz_ordins_in_h SELECT ALL
	 * </pre>
	 * @param requestData 요청정보 DataSet 객체
	 * @param onlineCtx 요청 컨텍스트 정보
	 * @return 처리결과 DataSet 객체
	 * <pre>
	 *	- recordSet : LIST [tb_cbs_xyz_ordins_in_h LIST ALL]
	 *		- field : TX_TYPE [TX_TYPE] (string)
	 *		- field : ACC_NO_1 [ACC_NO_1] (string)
	 *		- field : AMOUNT_1 [AMOUNT_1] (string)
	 *		- field : ACC_NO_2 [ACC_NO_2] (string)
	 *		- field : AMOUNT_2 [AMOUNT_2] (string)
	 *		- field : NOTES [NOTES] (string)
	 *		- field : STATUS [STATUS] (string)
	 *		- field : CRE_DTM [CRE_DTM] (string)
	 *		- field : UPD_DTM [UPD_DTM] (string)
	 * </pre>
	 * 
	 * @author admin (Administrator)
	 * @since 2021-06-30 18:07:03
	 */
	@BizMethod("tb_cbs_xyz_ordins_in_h SELECT ALL")
	public IDataSet s002(IDataSet requestData, IOnlineContext onlineCtx) {
	    IDataSet responseData = new DataSet();
	    
	    // Auto-generated execute db block
	    IRecordSet recordset = dbSelect("S002", requestData, onlineCtx);
	    
	    // Auto-generated make response block
	    responseData.put("LIST", recordset);
	    
	    // 처리 결과값을 responseData에 넣어서 리턴하십시요 
	
	    return responseData;
	}

	/**
	 * tb_cbs_xyz_ordins_in_h INSERT.
	 * <pre>
	 * tb_cbs_xyz_ordins_in_h INSERT
	 * </pre>
	 * @param requestData 요청정보 DataSet 객체
	 * <pre>
	 *	- field : TX_TYPE [TX_TYPE] (string)
	 *	- field : ACC_NO_1 [ACC_NO_1] (string)
	 *	- field : AMOUNT_1 [AMOUNT_1] (string)
	 *	- field : ACC_NO_2 [ACC_NO_2] (string)
	 *	- field : AMOUNT_2 [AMOUNT_2] (string)
	 *	- field : NOTES [NOTES] (string)
	 *	- field : STATUS [STATUS] (string)
	 *	- field : CRE_DTM [CRE_DTM] (string)
	 *	- field : UPD_DTM [UPD_DTM] (string)
	 * </pre>
	 * @param onlineCtx 요청 컨텍스트 정보
	 * @return 처리결과 DataSet 객체
	 * <pre>
	 *	- field : EXPECTED_ROW [EXPECTED_ROW] (int)
	 * </pre>
	 * 
	 * @author admin (Administrator)
	 * @since 2021-06-30 18:07:03
	 */
	@BizMethod("tb_cbs_xyz_ordins_in_h INSERT")
	public IDataSet i001(IDataSet requestData, IOnlineContext onlineCtx) {
	    IDataSet responseData = new DataSet();
	    
	    // Auto-generated execute db block
	    int row = dbInsert("I001", requestData, onlineCtx);
	    
	    // Auto-generated make response block
	    responseData.put("EXPECTED_ROW", row);
	    
	    // 처리 결과값을 responseData에 넣어서 리턴하십시요 
	
	    return responseData;
	}

	/**
	 * tb_cbs_xyz_ordins_in_h UPDATE.
	 * <pre>
	 * tb_cbs_xyz_ordins_in_h UPDATE
	 * </pre>
	 * @param requestData 요청정보 DataSet 객체
	 * <pre>
	 *	- field : TX_TYPE [TX_TYPE] (string)
	 *	- field : ACC_NO_1 [ACC_NO_1] (string)
	 *	- field : AMOUNT_1 [AMOUNT_1] (string)
	 *	- field : ACC_NO_2 [ACC_NO_2] (string)
	 *	- field : AMOUNT_2 [AMOUNT_2] (string)
	 *	- field : NOTES [NOTES] (string)
	 *	- field : STATUS [STATUS] (string)
	 *	- field : CRE_DTM [CRE_DTM] (string)
	 *	- field : UPD_DTM [UPD_DTM] (string)
	 * </pre>
	 * @param onlineCtx 요청 컨텍스트 정보
	 * @return 처리결과 DataSet 객체
	 * <pre>
	 *	- field : EXPECTED_ROW [EXPECTED_ROW] (int)
	 * </pre>
	 * 
	 * @author admin (Administrator)
	 * @since 2021-06-30 18:07:03
	 */
	@BizMethod("tb_cbs_xyz_ordins_in_h UPDATE")
	public IDataSet u001(IDataSet requestData, IOnlineContext onlineCtx) {
	    IDataSet responseData = new DataSet();
	    
	    // Auto-generated execute db block
	    int row = dbUpdate("U001", requestData, onlineCtx);
	    
	    // Auto-generated make response block
	    responseData.put("EXPECTED_ROW", row);
	    
	    // 처리 결과값을 responseData에 넣어서 리턴하십시요 
	
	    return responseData;
	}

	/**
	 * tb_cbs_xyz_ordins_in_h DELETE.
	 * <pre>
	 * tb_cbs_xyz_ordins_in_h DELETE
	 * </pre>
	 * @param requestData 요청정보 DataSet 객체
	 * @param onlineCtx 요청 컨텍스트 정보
	 * @return 처리결과 DataSet 객체
	 * <pre>
	 *	- field : EXPECTED_ROW [EXPECTED_ROW] (int)
	 * </pre>
	 * 
	 * @author admin (Administrator)
	 * @since 2021-06-30 18:07:03
	 */
	@BizMethod("tb_cbs_xyz_ordins_in_h DELETE")
	public IDataSet d001(IDataSet requestData, IOnlineContext onlineCtx) {
	    IDataSet responseData = new DataSet();
	    
	    // Auto-generated execute db block
	    int row = dbDelete("D001", requestData, onlineCtx);
	    
	    // Auto-generated make response block
	    responseData.put("EXPECTED_ROW", row);
	    
	    // 처리 결과값을 responseData에 넣어서 리턴하십시요 
	
	    return responseData;
	}

}