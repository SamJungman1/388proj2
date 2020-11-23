package iastate.edu.ecommerce.Project;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.lang.annotation.Annotation;
import java.math.BigInteger;
import java.util.List;

public class RepositoryImp implements Repo {

    @PersistenceContext
    private EntityManager em;

    private String clean(String str)
    {
        str = str.replaceAll("(\\r|\\n)", "");
        return str;
    }
    @Override
    public int returnVal(String token1, int expire) {
        String str = "call Check_Token(" + '"'+ token1 + '"'+ "," + expire + ")";

        Query output = em.createNativeQuery(str);

        List<BigInteger> out = output.getResultList();

        return out.get(0).intValue();

    }

    @Override
    @Transactional
    public void deleteToken(String token1) {
        String str = "call Delete_Token(" + '"'+ token1 + '"'+ ")";
        Query delete = em.createNativeQuery(str);
        delete.executeUpdate();
    }

    @Override
    @Transactional
    public void deleteUserToken(String email1) {
        String str = "call Delete_User_Token(" + '"'+ email1 + '"'+ ")";
        Query delete = em.createNativeQuery(str);
        delete.executeUpdate();
    }

    @Override
    public String returnEmail(String token1) {
        String str = "call Get_Email_From_Token(" + '"'+ token1 + '"' + ")";

        Query output = em.createNativeQuery(str);

        List<String> out = output.getResultList();

        return out.get(0);
    }

    @Override
    @Transactional
    public void save(Tokens token) {
        String str = "call Store_New_Token(" + '"'+ token.getVal() + '"'+ "," + '"'+ token.getEmail() + '"'+ "," + token.getExpires() + ")";
        Query store = em.createNativeQuery(str);
        store.executeUpdate();
    }


    @Override
    public String value() {
        return null;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
