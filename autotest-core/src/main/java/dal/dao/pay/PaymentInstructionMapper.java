package dal.dao.pay;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author ychaoyang
 * Created on 22.
 */
public interface PaymentInstructionMapper {

    @Select("SELECT  count(*)  FROM data_core_pay.deposit_instruction a where " +
            "a.payee_account_no =" +
            "(select b.account_no from data_core_user.account b where " +
            "b.user_id =#{userId} and " +
            "b.tag =#{tag})")
    public String findPaymentInstruction(@Param("userId") String userId, @Param("tag") String tag);
}
