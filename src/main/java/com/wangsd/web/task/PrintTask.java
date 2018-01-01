/**
 *
 */
package com.wangsd.web.task;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

/**
 * @Copyright: 本内容仅限于重庆爱赢科技有限公司内部使用，禁止转发.
 * @Author: lixingbiao 2017年10月10日 下午3:25:30
 * @Version: $Id$
 * @Desc: <p></p>
 */
@Component
public class PrintTask {
    private static Log log = LogFactory.getLog(PrintTask.class);

   /* @Autowired
    private BillaccountMapper billaccountMapper;
    @Autowired
    private PrintService printService;
    @Autowired
    private HousinginfoService housinginfoService;
    @Autowired
    private CosttypeMapper costtypeMapper;

    //每天晚上11点50执行
    @Scheduled(cron = "0 50 23 * * ?")
    public void printxiaoqu() {
        log.info("-----------wangshuodong:执行每个小区汇总打印------------");
        String date = DateUtils.getCurDate();
        //查询配置了打印机的小区
        List<Printinfo> list = printService.selectBystatus(StaticVar.PRINTINFO_STATUS0);
        for (Printinfo info : list) {
            PrintMessage printMessage = new PrintMessage(info.getMachineCode(), info.getMsign());
            //查询小区信息
            HousinginfoCustom housing = housinginfoService.selectHousingCustomById(info.getDepartmentId());
            //按支付方式统计小区
            List<BillAccountCustom> list1 = billaccountMapper.getPrintGroupByPayType(housing.getId());
            //按费用类型统计小区
            List<BillAccountCustom> list2 = billaccountMapper.getPrintGroupByCostType(housing.getId());
            //查询小区下面所有交易户数
            BillAccountCustom query = new BillAccountCustom();
            query.setHousingId(housing.getId());
            BillAccountCustom userCustom = billaccountMapper.getPrintUserCount(query);
            StringBuffer sb = new StringBuffer("");
            sb.append("<center>支付宝智慧小区</center>\n");
            sb.append("小区名称：" + housing.getName() + "\n");
            sb.append("汇总时间：" + date + "\n");
            BigDecimal totalAmount = new BigDecimal(0);
            for (BillAccountCustom billAccount : list1) {
                totalAmount = totalAmount.add(billAccount.getSumAmount());
            }
            sb.append("交易总额：" + totalAmount + "\n");
            sb.append("户数：" + userCustom.getUserNum() + "\n");
            sb.append("缴费明细：\n");
            sb.append("<table><tr><td>交易笔数</td><td>支付方式</td><td>金额</td></tr>");
            for (BillAccountCustom billAccount : list1) {
                String payType = ApplicationUtils.getPayType(billAccount.getPaytype());
                sb.append("<tr><td>" + billAccount.getCountNum() + "</td><td>" + payType + "</td><td>" + billAccount.getSumAmount() + "</td></tr>");
            }
            sb.append("</table>");
            sb.append("----------------------\n");
            sb.append("<table><tr><td>费用类型</td><td>金额</td></tr>");
            for (BillAccountCustom billAccount : list2) {
                //String costType = ApplicationUtils.getCostType(billAccount.getCostType());
                sb.append("<td>" + billAccount.getCostTypeName() + "</td><td>" + billAccount.getSumAmount() + "</td></tr>");
            }
            sb.append("</table>");
            sb.append("收款单位：" + housing.getParentName() + "\n");
            sb.append("<center>技术支持：早早科技/0571-88683117\n");
            sb.append("----------------------\n");
            sb.append("<center>交易小票</center>\n");
            printMessage.sendContent(sb.toString());
        }
    }

    //每天晚上12点执行
    @Scheduled(cron = "0 55 23 * * ?")
    public void printwuye() {
        log.info("-----------wangshuodong:执行物业汇总打印------------");
        String date = DateUtils.getCurDate();
        //查询配置了打印机的物业
        List<Printinfo> list = printService.selectBystatus(StaticVar.PRINTINFO_STATUS1);
        for (Printinfo info : list) {
            PrintMessage printMessage = new PrintMessage(info.getMachineCode(), info.getMsign());
            //根据物业id查询小区列表
            HousinginfoCustom housQuery = new HousinginfoCustom();
            housQuery.setParentId(info.getDepartmentId());
            List<HousinginfoCustom> housList = housinginfoService.queryHousingCustomAll(housQuery);
            //查询物业下面所有交易户数
            BillAccountCustom query = new BillAccountCustom();
            query.setPropertyId(info.getDepartmentId());
            BillAccountCustom userCustom = billaccountMapper.getPrintUserCount(query);
            //统计物业下面的账单统计
            List<BillAccountCustom> list1 = billaccountMapper.getPrintTotal(info.getDepartmentId());
            if (userCustom != null && userCustom.getCountNum() > 0) {
                StringBuffer sb = new StringBuffer("");
                sb.append("<center>支付宝智慧小区</center>\n");
                sb.append("汇总时间：" + date + "\n");
                sb.append("----------------------\n");
                sb.append("小区数量：" + housList.size() + "\n");
                sb.append("交易户数：" + userCustom.getCountNum() + "\n");
                sb.append("总额：" + userCustom.getSumAmount() + "\n");
                for (BillAccountCustom bill : list1) {
                    String payType = ApplicationUtils.getPayType(bill.getPaytype());
                    sb.append(payType + "：" + bill.getSumAmount() + "\n");
                }
                sb.append("----------------------\n");
                String propertyName = "";
                for (HousinginfoCustom housing : housList) {
                    propertyName = housing.getParentName();
                    sb.append("小区名称：" + housing.getName() + "\n");
                    //查询小区下面所有交易户数
                    BillAccountCustom query1 = new BillAccountCustom();
                    query1.setHousingId(housing.getId());
                    BillAccountCustom userCustom2 = billaccountMapper.getPrintUserCount(query1);
                    sb.append("交易户数：" + userCustom2.getCountNum() + "\n");
                    //按支付方式统计小区
                    List<BillAccountCustom> list2 = billaccountMapper.getPrintGroupByPayType(housing.getId());
                    BigDecimal totalAmount = new BigDecimal(0);
                    for (BillAccountCustom billAccount : list2) {
                        totalAmount = totalAmount.add(billAccount.getSumAmount());
                    }
                    sb.append("总额：" + totalAmount + "\n");
                    sb.append("----------------------\n");
                }

                sb.append("收款单位：" + propertyName + "\n");
                sb.append("<center>技术支持：早早科技/0571-88683117</center>\n");
                sb.append("----------------------\n");
                sb.append("<center>交易小票</center>\n");
                printMessage.sendContent(sb.toString());
            }
        }
    }*/
}
