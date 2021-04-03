package dao;
import java.util.List;
import vo.*;

public interface IStuDAO {
    public boolean doCreateStu(Stu stu) throws Exception ;//执行数据的插入操作
    public List<Stu> findAllStu() throws Exception ;//完成数据 的查询操作
    public List<Stu> findBySno(String sno) throws Exception ;//根据ID查询，返回所有Stu
    public List<Stu> findByBorrownumber(int borrownumber) throws Exception;// 根据借书数查询，返回Stu
    public boolean deleteStu(String sno) throws Exception;
    public boolean updateStu(Stu stu) throws Exception;
}
