package sg.edu.ntu.simpleexpenses.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.edu.ntu.simpleexpenses.pojo.Expenses;

public interface ExpensesRepository extends JpaRepository<Expenses, Long> {
    // List<Expenses> getExpensesByCategory(ExpenseCategory category, Double
    // minAmount, Double maxAmount);
}
