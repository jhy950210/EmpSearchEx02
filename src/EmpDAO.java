import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmpDAO {
private Connection conn = null;
	
	public EmpDAO() {
		// TODO Auto-generated constructor stub
		// 데이터 연결
		String url = "jdbc:mysql://localhost:3306/sample";
		String user = "root";
		String password = "123456";
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("드라이버 로딩 완료");
			conn = DriverManager.getConnection(url, user, password);
	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("[에러] : " + e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("[에러] : " + e.getMessage());
		} 
		
	}
	
	public ArrayList<ArrayList<String>> allArrayListEmp(){
		// sido 데이터 검색
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<ArrayList<String>> datas = new ArrayList<ArrayList<String>>();

		try {
			String sql = "select * from emp";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();

			while(rs.next()) {
				String empno = rs.getString("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				String mgr = rs.getString("mgr");
				String hiredate = rs.getString("hiredate");
				String sal = rs.getString("sal");
				String comm = rs.getString("comm");
				String deptno = rs.getString("deptno");
				
				ArrayList<String> data = new ArrayList<String>(); 
				
				// 한 행을 만들기
				data.add(empno);
				data.add(ename);
				data.add(job);
				data.add(mgr);
				data.add(hiredate);
				data.add(sal);
				data.add(comm);
				data.add(deptno);
				
				datas.add(data); // 여러 줄로 쌓아 올리기
				
			}
		} catch(SQLException e) {
			System.out.println("[에러] : " + e.getMessage());
		}finally {
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
			if(rs!=null) try {rs.close();} catch(SQLException e) {}
		}
		
		return datas;
	}
	
	public ArrayList<EmpTO> allEmpTO(){
		// sido 데이터 검색
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<EmpTO> datas = new ArrayList<EmpTO>();

		try {
			String sql = "select * from emp";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();

			while(rs.next()) {
				String empno = rs.getString("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				String mgr = rs.getString("mgr");
				String hiredate = rs.getString("hiredate");
				String sal = rs.getString("sal");
				String comm = rs.getString("comm");
				String deptno = rs.getString("deptno");
				
				EmpTO data = new EmpTO(); 
				
				// 한 행을 만들기
				data.setEmpno(empno);
				data.setEname(ename);
				data.setJob(job);
				data.setHiredate(hiredate);
				data.setMgr(mgr);
				data.setSal(sal);
				data.setComm(comm);
				data.setDeptno(deptno);
				
				datas.add(data); // 여러 줄로 쌓아 올리기
				
			}
		} catch(SQLException e) {
			System.out.println("[에러] : " + e.getMessage());
		}finally {
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
			if(rs!=null) try {rs.close();} catch(SQLException e) {}
		}
		
		return datas;
	}
	
}

