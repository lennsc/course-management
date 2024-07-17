package courseManagement.utils;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EListTypeHandler extends BaseTypeHandler<EList<?>> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, EList<?> parameter, JdbcType jdbcType) throws SQLException {
        // Implementation is not necessary for reading data
    }

    @Override
    public EList<?> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return createEList(rs);
    }

    @Override
    public EList<?> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return createEList(rs);
    }

    @Override
    public EList<?> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return null; // Not used
    }

    private EList<?> createEList(ResultSet rs) throws SQLException {
        EList<Object> list = new BasicEList<>();
        while (rs.next()) {
            list.add(rs.getObject(1)); // Customize this as needed
        }
        return list;
    }
}
