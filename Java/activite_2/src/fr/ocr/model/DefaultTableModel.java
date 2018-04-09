package fr.ocr.model;

public interface DefaultTableModel {
	abstract void removeRow(int row);
	abstract Object getItem(int index);
	abstract void addRow(Object row);
}
