package nexbank.xyz.ordins.biz;

import org.apache.commons.logging.Log;

import nexbank.common.CommonArea;
import nexcore.framework.core.component.streotype.BizMethod;
import nexcore.framework.core.component.streotype.BizUnit;
import nexcore.framework.core.component.streotype.BizUnitBind;
import nexcore.framework.core.data.DataSet;
import nexcore.framework.core.data.IDataSet;
import nexcore.framework.core.data.IOnlineContext;
import nexcore.framework.core.data.IRecordSet;
import nexcore.framework.core.exception.BizRuntimeException;
import nexcore.framework.core.log.ILog;
import nexcore.framework.core.util.DateUtils;

/**
 * 상시감사 메인.
 * <pre>
 * 상시감사 메인
 * </pre>
 * 
 * @author admin (Administrator)
 * @since 2021-06-30 18:10:33
 */
@BizUnit(value = "상시감사 메인", type = "PU")
public class PXYZ8801 extends nexbank.fwk.base.ProcessUnit {

	@BizUnitBind 
	private DTB_CBS_XYZ_ORDINS_IN_H_00  dTB_CBS_XYZ_ORDINS_IN_H_00;

	/**
	 * 상시감사 등록.
	 * <pre>
	 * 상시감사 등록
	 * </pre>
	 * @param requestData 요청정보 DataSet 객체
	 * <pre>
	 *	- dataSet : WITHDRAW [출금정보]
	 *		- field : ACC_NO [출금계좌번호] (string)
	 *		- field : ACC_PASSWD [출금계좌비밀번호] (string)
	 *		- field : DESCRIPTION [출금계좌메시지] (string)
	 *	- dataSet : DEPOSIT [입금정보]
	 *		- field : ACC_NO [입금계좌번호] (string)
	 *		- field : DESCRIPTION [입금계좌메시지] (string)
	 *	- field : AMOUNT [금액] (long)
	 * </pre>
	 * @param onlineCtx 요청 컨텍스트 정보
	 * @return 처리결과 DataSet 객체
	 * <pre>
	 * </pre>
	 * 
	 * @author admin (Administrator)
	 * @since 2021-06-30 18:10:51
	 */
	@BizMethod("상시감사 등록")
	public IDataSet pXYZ88001(IDataSet requestData, IOnlineContext onlineCtx) {
	    IDataSet   responseData = new DataSet();
	    ILog       log = getLog(onlineCtx);
	    CommonArea ca  = getCommonArea(onlineCtx);
		
		try {
			if (requestData.getLong("AMOUNT") > 1000000) { // 100 만원 이상이면 상시감사 대상
				log.info("이체 금액 100만원 초과로 상시감사 등록 ");
				IDataSet withdraw = requestData.getDataSet("WITHDRAW");
				IDataSet deposit  = requestData.getDataSet("DEPOSIT");
				
				/**********************************************************************/
			    IDataSet i001Req = new DataSet();
				i001Req.put("TX_TYPE",  "이체"); // TX_TYPE
				i001Req.put("ACC_NO_1", withdraw.get("ACC_NO")); // ACC_NO_1
				i001Req.put("AMOUNT_1", withdraw.get("AMOUNT")); // ACC_NO_1
				i001Req.put("ACC_NO_2", deposit.get("ACC_NO")); // ACC_NO_2
				i001Req.put("AMOUNT_2", deposit.get("AMOUNT")); // AMOUNT_2
				i001Req.put("NOTES",    "100만원초과 이체 ("+withdraw.getString("DESCRIPTION")+")"); // NOTES
				i001Req.put("STATUS",   "등록"); // STATUS
				i001Req.put("CRE_DTM",  DateUtils.getDateString("yyyyMMddHHmmssSSS")); // CRE_DTM
				i001Req.put("UPD_DTM",  DateUtils.getDateString("yyyyMMddHHmmssSSS")); // UPD_DTM
	
				// @@ 메소드 호출 (tb_cbs_xyz_ordins_in_h INSERT Dtb_cbs_xyz_ordins_in_h_00.i001)
				dTB_CBS_XYZ_ORDINS_IN_H_00.i001(i001Req, onlineCtx);
			    /**********************************************************************/
			}
		    
		}catch(BizRuntimeException e) { 
		    throw e; // 업무에러는 그대로 throw.
		}catch(Exception e) {
		    throw new BizRuntimeException("ERR00012", e);
		}
		
	    // 처리 결과값을 responseData에 넣어서 리턴하십시요 
	    return responseData;
	}

	/**
	 * 상시감사 조회.
	 * <pre>
	 * 상시감사 조회
	 * </pre>
	 * @param requestData 요청정보 DataSet 객체
	 * <pre>
	 * </pre>
	 * @param onlineCtx 요청 컨텍스트 정보
	 * @return 처리결과 DataSet 객체
	 * <pre>
	 * </pre>
	 * 
	 * @author admin (Administrator)
	 * @since 2021-06-30 18:10:51
	 */
	@BizMethod("상시감사 조회")
	public IDataSet pXYZ88002(IDataSet requestData, IOnlineContext onlineCtx) {
	    IDataSet   responseData = new DataSet();
	    ILog       log = getLog(onlineCtx);
	    CommonArea ca  = getCommonArea(onlineCtx);
		
		try {
		    IDataSet s002Req = new DataSet();

			// @@ 메소드 호출 (tb_cbs_xyz_ordins_in_h SELECT ALL DTB_CBS_XYZ_ORDINS_IN_H_00.s002)
		    IDataSet s002Res = dTB_CBS_XYZ_ORDINS_IN_H_00.s002(s002Req, onlineCtx);

		    IRecordSet list = s002Res.getRecordSet("LIST");
			responseData.put("COUNT", list.getRecordCount());
			responseData.put("LIST",  list);
			
		}catch(BizRuntimeException e) { 
		    throw e; // 업무에러는 그대로 throw.
		}catch(Exception e) {
		    throw new BizRuntimeException("ERR00012", e);
		}
		
	    // 처리 결과값을 responseData에 넣어서 리턴하십시요 
	    return responseData;
	}

}