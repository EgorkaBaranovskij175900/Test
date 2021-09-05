package by.tms.service;




import by.tms.entity.Operation;
import by.tms.DAO.OperationDAO;

import java.util.List;

public class CalcService {

	private final OperationDAO operationDAO = new OperationDAO();

	public Operation calc(double a, double b, String operation) {
		switch (operation) {
			case "sum":
				Operation operation1 = new Operation(a, b, operation, a + b);
				operationDAO.save(operation1);
				return operation1;
			case "sub":
				Operation operation2 = new Operation(a, b, operation, a - b);
				operationDAO.save(operation2);
				return operation2;
			case "div":
				Operation operation3 = new Operation(a, b, operation, a - b);
				operationDAO.save(operation3);
				return operation3;
			case "mul":
				Operation operation4 = new Operation(a, b, operation, a - b);
				operationDAO.save(operation4);
				return operation4;
		}
		return null;
	}

	public List<Operation> findAll(){
		return operationDAO.getAll();
	}
}
