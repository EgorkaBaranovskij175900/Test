package by.tms.DAO;


import by.tms.DAO.interfaces.Constants;
import by.tms.DAO.interfaces.OperationInterface;
import by.tms.entity.Operation;
import by.tms.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Repository
public class OperationDAO implements OperationInterface , Constants {
    @PersistenceContext
    private EntityManager entitymanager;

    @Transactional
    @Override
    public void save(Operation operation) {
        entitymanager.persist(operation);
    }

    @Override
    @Transactional
    public List<Operation> getAll() {
        TypedQuery<Operation> tq = entitymanager.createNamedQuery(GET_ALL_OPERATION, Operation.class);
        List<Operation> resultList = tq.getResultList();
        return resultList;
    }



}
