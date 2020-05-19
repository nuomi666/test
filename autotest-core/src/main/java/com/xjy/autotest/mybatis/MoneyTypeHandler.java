package com.xjy.autotest.mybatis;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.xyb.adk.common.util.money.Money;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;


@MappedTypes(Money.class)
public class MoneyTypeHandler extends BaseTypeHandler<Money> {
	
	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, Money parameter,
									JdbcType jdbcType) throws SQLException {
		ps.setLong(i, parameter.getCent());
	}
	
	@Override
	public Money getNullableResult(ResultSet rs, String columnName) throws SQLException {
		long result = rs.getLong(columnName);
		Money money = new Money();
		money.setCent(result);
		return money;
	}
	
	@Override
	public Money getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		long result = rs.getLong(columnIndex);
		Money money = new Money();
		money.setCent(result);
		return money;
	}
	
	@Override
	public Money getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		long result = cs.getLong(columnIndex);
		Money money = new Money();
		money.setCent(result);
		return money;
	}
	
}
