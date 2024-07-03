package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {
	
	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	// Criar Associações - Composição de Objetos
	private Department department;
	// Representar vários com uma Lista - não colocar no construtor objetos que sejam lista
	// Lista deve ser instanciada
	private List<HourContract> contracts = new ArrayList<>();
	
	public Worker() {
	}

	public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	// Apagar setContracts - não pode deixar lista ser trocada
	public List<HourContract> getContracts() {
		return contracts;
	}
	// Métodos responsáveis por fazer ou desfazer uma associação entre um trabalhador e um contrato
	public void addContract(HourContract contract) {
		contracts.add(contract);
	}
	
	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}
	
	public double income(int year, int month) {
		double sum = baseSalary;
		for (HourContract c : contracts) {
			LocalDate contractDate = c.getDate();
			if (year == contractDate.getYear() && month == contractDate.getMonthValue()) {
				sum += c.totalValue();
			}
		}
		return sum;
	}
}
