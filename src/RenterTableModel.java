import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class RenterTableModel extends AbstractTableModel {

    protected static final String[] COLUMN_NAMES = {
        "Name/Org",
        "Checkout Date",
        "Locker Number"
    };

    private List<Renter> rowData;

    public RenterTableModel(ArrayList<Renter> renters) {
        rowData = renters;
    }

    public void add(Renter r) {
        add(r);
    }

    public void add(List<Renter> pd) {
        rowData.addAll(pd);
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return rowData.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }

    public Renter getRenterAt(int row) {
        return rowData.get(row);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    	 Renter  r = getRenterAt(rowIndex);
    	 Object value = r;
        switch (columnIndex) {
            case 0:
                value = r.getRenterName();
                break;
            case 1:
                value = r.getRental().getDate();
                break;
            case 2:
                value = r.getRental().getLocker().getLockerNumber();
                break;
        }
        return value;
    }

}