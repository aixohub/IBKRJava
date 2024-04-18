package com.trader.apidemo;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class WSHEventDataModel extends AbstractTableModel {

  private static final String[] columnNames = new String[]{"Data JSON"};
  private final List<MetaDataItem> m_rows = new ArrayList<>();

  @Override
  public String getColumnName(int column) {
    return columnNames[column];
  }

  @Override
  public int getRowCount() {
    return m_rows.size();
  }

  @Override
  public int getColumnCount() {
    return columnNames.length;
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    MetaDataItem item = m_rows.get(rowIndex);

    switch (columnIndex) {
      case 0:
        return item.dataJson();
    }

    return null;
  }

  public void addRow(String dataJson) {
    m_rows.add(new MetaDataItem(dataJson));

    fireTableDataChanged();
  }

  private class MetaDataItem {

    private final String m_dataJson;

    public MetaDataItem(String dataJson) {
      m_dataJson = dataJson;
    }

    public String dataJson() {
      return m_dataJson;
    }

  }

}
