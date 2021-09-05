package by.tms.DAO.interfaces;

import by.tms.entity.Operation;


import java.util.List;

public interface OperationInterface {
    public void save(Operation operation);
    public List<Operation> getAll();
}
