import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class CustomTableModel extends AbstractTableModel {
	private ArrayList<ArrayList<String>> values;

	private String[] names = new String[] {
			"empno", "ename", "job", "mgr", "hiredate", "sal", "comm", "deptno"
	};
	
	
	public CustomTableModel() {
		// TODO Auto-generated constructor stub
		EmpDAO dao = new EmpDAO();
		values = dao.allArrayListEmp();
	}
	
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return names[column];
	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return values.get(0).size();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return values.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return values.get(rowIndex).get(columnIndex);
	}

}
