package javax.sql.rowset;

public class CachedRowSetImpl implements javax.sql.rowset.CachedRowSet {

    @Override
    public int size() { return 0; }

    @Override
    public void execute(java.sql.Connection args0) { return ; }

    @Override
    public void release() { return ; }

    @Override
    public void acceptChanges() { return ; }

    @Override
    public void acceptChanges(java.sql.Connection args0) { return ; }

    @Override
    public boolean columnUpdated(int args0) { return true; }

    @Override
    public boolean columnUpdated(java.lang.String args0) { return true; }

    @Override
    public void commit() { return ; }

    @Override
    public javax.sql.rowset.CachedRowSet createCopy() { return null; }

    @Override
    public javax.sql.rowset.CachedRowSet createCopyNoConstraints() { return null; }

    @Override
    public javax.sql.rowset.CachedRowSet createCopySchema() { return null; }

    @Override
    public javax.sql.RowSet createShared() { return null; }

    @Override
    public int[] getKeyColumns() { return null; }

    @Override
    public java.sql.ResultSet getOriginal() { return null; }

    @Override
    public java.sql.ResultSet getOriginalRow() { return null; }

    @Override
    public int getPageSize() { return 0; }

    @Override
    public javax.sql.rowset.RowSetWarning getRowSetWarnings() { return null; }

    @Override
    public boolean getShowDeleted() { return true; }

    @Override
    public javax.sql.rowset.spi.SyncProvider getSyncProvider() { return null; }

    @Override
    public java.lang.String getTableName() { return null; }

    @Override
    public boolean nextPage() { return true; }

    @Override
    public void populate(java.sql.ResultSet args0, int args1) { return ; }

    @Override
    public void populate(java.sql.ResultSet args0) { return ; }

    @Override
    public boolean previousPage() { return true; }

    @Override
    public void restoreOriginal() { return ; }

    @Override
    public void rowSetPopulated(javax.sql.RowSetEvent args0, int args1) { return ; }

    @Override
    public void setKeyColumns(int[] args0) { return ; }

    @Override
    public void setMetaData(javax.sql.RowSetMetaData args0) { return ; }

    @Override
    public void setOriginalRow() { return ; }

    @Override
    public void setPageSize(int args0) { return ; }

    @Override
    public void setShowDeleted(boolean args0) { return ; }

    @Override
    public void setSyncProvider(java.lang.String args0) { return ; }

    @Override
    public void setTableName(java.lang.String args0) { return ; }

    @Override
    public java.util.Collection toCollection() { return null; }

    @Override
    public java.util.Collection toCollection(java.lang.String args0) { return null; }

    @Override
    public java.util.Collection toCollection(int args0) { return null; }

    @Override
    public void undoDelete() { return ; }

    @Override
    public void undoInsert() { return ; }

    @Override
    public void undoUpdate() { return ; }

    @Override
    public void rollback(java.sql.Savepoint args0) { return ; }

    @Override
    public void rollback() { return ; }

    @Override
    public void setURL(int args0, java.net.URL args1) { return ; }

    @Override
    public void execute() { return ; }

    @Override
    public void setReadOnly(boolean args0) { return ; }

    @Override
    public void setBoolean(int args0, boolean args1) { return ; }

    @Override
    public void setBoolean(java.lang.String args0, boolean args1) { return ; }

    @Override
    public void setByte(int args0, byte args1) { return ; }

    @Override
    public void setByte(java.lang.String args0, byte args1) { return ; }

    @Override
    public void setDouble(int args0, double args1) { return ; }

    @Override
    public void setDouble(java.lang.String args0, double args1) { return ; }

    @Override
    public void setFloat(int args0, float args1) { return ; }

    @Override
    public void setFloat(java.lang.String args0, float args1) { return ; }

    @Override
    public void setInt(java.lang.String args0, int args1) { return ; }

    @Override
    public void setInt(int args0, int args1) { return ; }

    @Override
    public void setLong(int args0, long args1) { return ; }

    @Override
    public void setLong(java.lang.String args0, long args1) { return ; }

    @Override
    public void setShort(java.lang.String args0, short args1) { return ; }

    @Override
    public void setShort(int args0, short args1) { return ; }

    @Override
    public boolean isReadOnly() { return true; }

    @Override
    public void setTimestamp(int args0, java.sql.Timestamp args1) { return ; }

    @Override
    public void setTimestamp(int args0, java.sql.Timestamp args1, java.util.Calendar args2) { return ; }

    @Override
    public void setTimestamp(java.lang.String args0, java.sql.Timestamp args1) { return ; }

    @Override
    public void setTimestamp(java.lang.String args0, java.sql.Timestamp args1, java.util.Calendar args2) { return ; }

    @Override
    public void setTime(int args0, java.sql.Time args1) { return ; }

    @Override
    public void setTime(int args0, java.sql.Time args1, java.util.Calendar args2) { return ; }

    @Override
    public void setTime(java.lang.String args0, java.sql.Time args1) { return ; }

    @Override
    public void setTime(java.lang.String args0, java.sql.Time args1, java.util.Calendar args2) { return ; }

    @Override
    public void setDate(int args0, java.sql.Date args1) { return ; }

    @Override
    public void setDate(int args0, java.sql.Date args1, java.util.Calendar args2) { return ; }

    @Override
    public void setDate(java.lang.String args0, java.sql.Date args1, java.util.Calendar args2) { return ; }

    @Override
    public void setDate(java.lang.String args0, java.sql.Date args1) { return ; }

    @Override
    public void addRowSetListener(javax.sql.RowSetListener args0) { return ; }

    @Override
    public void clearParameters() { return ; }

    @Override
    public java.lang.String getCommand() { return null; }

    @Override
    public java.lang.String getDataSourceName() { return null; }

    @Override
    public boolean getEscapeProcessing() { return true; }

    @Override
    public int getMaxFieldSize() { return 0; }

    @Override
    public int getMaxRows() { return 0; }

    @Override
    public int getQueryTimeout() { return 0; }

    @Override
    public int getTransactionIsolation() { return 0; }

    @Override
    public java.util.Map getTypeMap() { return null; }

    @Override
    public java.lang.String getUrl() { return null; }

    @Override
    public java.lang.String getUsername() { return null; }

    @Override
    public void removeRowSetListener(javax.sql.RowSetListener args0) { return ; }

    @Override
    public void setArray(int args0, java.sql.Array args1) { return ; }

    @Override
    public void setAsciiStream(int args0, java.io.InputStream args1, int args2) { return ; }

    @Override
    public void setAsciiStream(java.lang.String args0, java.io.InputStream args1) { return ; }

    @Override
    public void setAsciiStream(java.lang.String args0, java.io.InputStream args1, int args2) { return ; }

    @Override
    public void setAsciiStream(int args0, java.io.InputStream args1) { return ; }

    @Override
    public void setBigDecimal(int args0, java.math.BigDecimal args1) { return ; }

    @Override
    public void setBigDecimal(java.lang.String args0, java.math.BigDecimal args1) { return ; }

    @Override
    public void setBinaryStream(java.lang.String args0, java.io.InputStream args1) { return ; }

    @Override
    public void setBinaryStream(int args0, java.io.InputStream args1, int args2) { return ; }

    @Override
    public void setBinaryStream(int args0, java.io.InputStream args1) { return ; }

    @Override
    public void setBinaryStream(java.lang.String args0, java.io.InputStream args1, int args2) { return ; }

    @Override
    public void setBlob(java.lang.String args0, java.sql.Blob args1) { return ; }

    @Override
    public void setBlob(int args0, java.io.InputStream args1) { return ; }

    @Override
    public void setBlob(java.lang.String args0, java.io.InputStream args1) { return ; }

    @Override
    public void setBlob(java.lang.String args0, java.io.InputStream args1, long args2) { return ; }

    @Override
    public void setBlob(int args0, java.io.InputStream args1, long args2) { return ; }

    @Override
    public void setBlob(int args0, java.sql.Blob args1) { return ; }

    @Override
    public void setBytes(java.lang.String args0, byte[] args1) { return ; }

    @Override
    public void setBytes(int args0, byte[] args1) { return ; }

    @Override
    public void setCharacterStream(java.lang.String args0, java.io.Reader args1) { return ; }

    @Override
    public void setCharacterStream(int args0, java.io.Reader args1) { return ; }

    @Override
    public void setCharacterStream(java.lang.String args0, java.io.Reader args1, int args2) { return ; }

    @Override
    public void setCharacterStream(int args0, java.io.Reader args1, int args2) { return ; }

    @Override
    public void setClob(int args0, java.io.Reader args1) { return ; }

    @Override
    public void setClob(java.lang.String args0, java.io.Reader args1) { return ; }

    @Override
    public void setClob(java.lang.String args0, java.sql.Clob args1) { return ; }

    @Override
    public void setClob(int args0, java.io.Reader args1, long args2) { return ; }

    @Override
    public void setClob(int args0, java.sql.Clob args1) { return ; }

    @Override
    public void setClob(java.lang.String args0, java.io.Reader args1, long args2) { return ; }

    @Override
    public void setCommand(java.lang.String args0) { return ; }

    @Override
    public void setConcurrency(int args0) { return ; }

    @Override
    public void setDataSourceName(java.lang.String args0) { return ; }

    @Override
    public void setEscapeProcessing(boolean args0) { return ; }

    @Override
    public void setMaxFieldSize(int args0) { return ; }

    @Override
    public void setMaxRows(int args0) { return ; }

    @Override
    public void setNCharacterStream(java.lang.String args0, java.io.Reader args1) { return ; }

    @Override
    public void setNCharacterStream(int args0, java.io.Reader args1, long args2) { return ; }

    @Override
    public void setNCharacterStream(int args0, java.io.Reader args1) { return ; }

    @Override
    public void setNCharacterStream(java.lang.String args0, java.io.Reader args1, long args2) { return ; }

    @Override
    public void setNClob(java.lang.String args0, java.sql.NClob args1) { return ; }

    @Override
    public void setNClob(int args0, java.io.Reader args1) { return ; }

    @Override
    public void setNClob(int args0, java.sql.NClob args1) { return ; }

    @Override
    public void setNClob(int args0, java.io.Reader args1, long args2) { return ; }

    @Override
    public void setNClob(java.lang.String args0, java.io.Reader args1) { return ; }

    @Override
    public void setNClob(java.lang.String args0, java.io.Reader args1, long args2) { return ; }

    @Override
    public void setNString(int args0, java.lang.String args1) { return ; }

    @Override
    public void setNString(java.lang.String args0, java.lang.String args1) { return ; }

    @Override
    public void setNull(java.lang.String args0, int args1) { return ; }

    @Override
    public void setNull(java.lang.String args0, int args1, java.lang.String args2) { return ; }

    @Override
    public void setNull(int args0, int args1, java.lang.String args2) { return ; }

    @Override
    public void setNull(int args0, int args1) { return ; }

    @Override
    public void setObject(java.lang.String args0, java.lang.Object args1) { return ; }

    @Override
    public void setObject(java.lang.String args0, java.lang.Object args1, int args2) { return ; }

    @Override
    public void setObject(int args0, java.lang.Object args1, int args2) { return ; }

    @Override
    public void setObject(int args0, java.lang.Object args1, int args2, int args3) { return ; }

    @Override
    public void setObject(java.lang.String args0, java.lang.Object args1, int args2, int args3) { return ; }

    @Override
    public void setObject(int args0, java.lang.Object args1) { return ; }

    @Override
    public void setPassword(java.lang.String args0) { return ; }

    @Override
    public void setQueryTimeout(int args0) { return ; }

    @Override
    public void setRef(int args0, java.sql.Ref args1) { return ; }

    @Override
    public void setRowId(java.lang.String args0, java.sql.RowId args1) { return ; }

    @Override
    public void setRowId(int args0, java.sql.RowId args1) { return ; }

    @Override
    public void setSQLXML(int args0, java.sql.SQLXML args1) { return ; }

    @Override
    public void setSQLXML(java.lang.String args0, java.sql.SQLXML args1) { return ; }

    @Override
    public void setString(java.lang.String args0, java.lang.String args1) { return ; }

    @Override
    public void setString(int args0, java.lang.String args1) { return ; }

    @Override
    public void setTransactionIsolation(int args0) { return ; }

    @Override
    public void setTypeMap(java.util.Map args0) { return ; }

    @Override
    public void setUrl(java.lang.String args0) { return ; }

    @Override
    public void setUsername(java.lang.String args0) { return ; }

    @Override
    public java.lang.String getPassword() { return null; }

    @Override
    public void setType(int args0) { return ; }

    @Override
    public java.lang.String getString(int args0) { return null; }

    @Override
    public java.lang.String getString(java.lang.String args0) { return null; }

    @Override
    public void updateBytes(java.lang.String args0, byte[] args1) { return ; }

    @Override
    public void updateBytes(int args0, byte[] args1) { return ; }

    @Override
    public java.lang.Object getObject(int args0, java.util.Map args1) { return null; }

    @Override
    public java.lang.Object getObject(java.lang.String args0, java.util.Map args1) { return null; }

    @Override
    public java.lang.Object getObject(java.lang.String args0) { return null; }

    @Override
    public java.lang.Object getObject(int args0) { return null; }

    @Override
    public java.lang.Object getObject(java.lang.String args0, java.lang.Class args1) { return null; }

    @Override
    public java.lang.Object getObject(int args0, java.lang.Class args1) { return null; }

    @Override
    public boolean getBoolean(int args0) { return true; }

    @Override
    public boolean getBoolean(java.lang.String args0) { return true; }

    @Override
    public byte getByte(int args0) { return 0; }

    @Override
    public byte getByte(java.lang.String args0) { return 0; }

    @Override
    public short getShort(int args0) { return 0; }

    @Override
    public short getShort(java.lang.String args0) { return 0; }

    @Override
    public int getInt(java.lang.String args0) { return 0; }

    @Override
    public int getInt(int args0) { return 0; }

    @Override
    public long getLong(java.lang.String args0) { return 0; }

    @Override
    public long getLong(int args0) { return 0; }

    @Override
    public float getFloat(int args0) { return 0; }

    @Override
    public float getFloat(java.lang.String args0) { return 0; }

    @Override
    public double getDouble(java.lang.String args0) { return 0; }

    @Override
    public double getDouble(int args0) { return 0; }

    @Override
    public byte[] getBytes(java.lang.String args0) { return null; }

    @Override
    public byte[] getBytes(int args0) { return null; }

    @Override
    public boolean next() { return true; }

    @Override
    public java.sql.Array getArray(int args0) { return null; }

    @Override
    public java.sql.Array getArray(java.lang.String args0) { return null; }

    @Override
    public java.net.URL getURL(int args0) { return null; }

    @Override
    public java.net.URL getURL(java.lang.String args0) { return null; }

    @Override
    public boolean first() { return true; }

    @Override
    public void close() { return ; }

    @Override
    public int getType() { return 0; }

    @Override
    public boolean previous() { return true; }

    @Override
    public java.sql.Ref getRef(int args0) { return null; }

    @Override
    public java.sql.Ref getRef(java.lang.String args0) { return null; }

    @Override
    public java.sql.Time getTime(int args0) { return null; }

    @Override
    public java.sql.Time getTime(java.lang.String args0, java.util.Calendar args1) { return null; }

    @Override
    public java.sql.Time getTime(int args0, java.util.Calendar args1) { return null; }

    @Override
    public java.sql.Time getTime(java.lang.String args0) { return null; }

    @Override
    public java.sql.Date getDate(int args0, java.util.Calendar args1) { return null; }

    @Override
    public java.sql.Date getDate(java.lang.String args0, java.util.Calendar args1) { return null; }

    @Override
    public java.sql.Date getDate(int args0) { return null; }

    @Override
    public java.sql.Date getDate(java.lang.String args0) { return null; }

    @Override
    public java.sql.Timestamp getTimestamp(int args0, java.util.Calendar args1) { return null; }

    @Override
    public java.sql.Timestamp getTimestamp(java.lang.String args0, java.util.Calendar args1) { return null; }

    @Override
    public java.sql.Timestamp getTimestamp(java.lang.String args0) { return null; }

    @Override
    public java.sql.Timestamp getTimestamp(int args0) { return null; }

    @Override
    public boolean last() { return true; }

    @Override
    public boolean absolute(int args0) { return true; }

    @Override
    public void afterLast() { return ; }

    @Override
    public void beforeFirst() { return ; }

    @Override
    public void cancelRowUpdates() { return ; }

    @Override
    public void clearWarnings() { return ; }

    @Override
    public void deleteRow() { return ; }

    @Override
    public int findColumn(java.lang.String args0) { return 0; }

    @Override
    public java.io.InputStream getAsciiStream(int args0) { return null; }

    @Override
    public java.io.InputStream getAsciiStream(java.lang.String args0) { return null; }

    @Override
    public java.math.BigDecimal getBigDecimal(java.lang.String args0, int args1) { return null; }

    @Override
    public java.math.BigDecimal getBigDecimal(int args0, int args1) { return null; }

    @Override
    public java.math.BigDecimal getBigDecimal(int args0) { return null; }

    @Override
    public java.math.BigDecimal getBigDecimal(java.lang.String args0) { return null; }

    @Override
    public java.io.InputStream getBinaryStream(int args0) { return null; }

    @Override
    public java.io.InputStream getBinaryStream(java.lang.String args0) { return null; }

    @Override
    public java.sql.Blob getBlob(int args0) { return null; }

    @Override
    public java.sql.Blob getBlob(java.lang.String args0) { return null; }

    @Override
    public java.io.Reader getCharacterStream(java.lang.String args0) { return null; }

    @Override
    public java.io.Reader getCharacterStream(int args0) { return null; }

    @Override
    public java.sql.Clob getClob(java.lang.String args0) { return null; }

    @Override
    public java.sql.Clob getClob(int args0) { return null; }

    @Override
    public int getConcurrency() { return 0; }

    @Override
    public java.lang.String getCursorName() { return null; }

    @Override
    public int getFetchDirection() { return 0; }

    @Override
    public int getFetchSize() { return 0; }

    @Override
    public int getHoldability() { return 0; }

    @Override
    public java.sql.ResultSetMetaData getMetaData() { return null; }

    @Override
    public java.io.Reader getNCharacterStream(int args0) { return null; }

    @Override
    public java.io.Reader getNCharacterStream(java.lang.String args0) { return null; }

    @Override
    public java.sql.NClob getNClob(java.lang.String args0) { return null; }

    @Override
    public java.sql.NClob getNClob(int args0) { return null; }

    @Override
    public java.lang.String getNString(int args0) { return null; }

    @Override
    public java.lang.String getNString(java.lang.String args0) { return null; }

    @Override
    public int getRow() { return 0; }

    @Override
    public java.sql.RowId getRowId(int args0) { return null; }

    @Override
    public java.sql.RowId getRowId(java.lang.String args0) { return null; }

    @Override
    public boolean isClosed() { return true; }

    @Override
    public java.sql.SQLXML getSQLXML(int args0) { return null; }

    @Override
    public java.sql.SQLXML getSQLXML(java.lang.String args0) { return null; }

    @Override
    public java.io.InputStream getUnicodeStream(java.lang.String args0) { return null; }

    @Override
    public java.io.InputStream getUnicodeStream(int args0) { return null; }

    @Override
    public java.sql.SQLWarning getWarnings() { return null; }

    @Override
    public void insertRow() { return ; }

    @Override
    public boolean isAfterLast() { return true; }

    @Override
    public boolean isBeforeFirst() { return true; }

    @Override
    public boolean isLast() { return true; }

    @Override
    public void moveToCurrentRow() { return ; }

    @Override
    public void moveToInsertRow() { return ; }

    @Override
    public void refreshRow() { return ; }

    @Override
    public boolean relative(int args0) { return true; }

    @Override
    public boolean rowDeleted() { return true; }

    @Override
    public boolean rowInserted() { return true; }

    @Override
    public boolean rowUpdated() { return true; }

    @Override
    public void setFetchDirection(int args0) { return ; }

    @Override
    public void setFetchSize(int args0) { return ; }

    @Override
    public void updateArray(int args0, java.sql.Array args1) { return ; }

    @Override
    public void updateArray(java.lang.String args0, java.sql.Array args1) { return ; }

    @Override
    public void updateAsciiStream(java.lang.String args0, java.io.InputStream args1) { return ; }

    @Override
    public void updateAsciiStream(int args0, java.io.InputStream args1, long args2) { return ; }

    @Override
    public void updateAsciiStream(int args0, java.io.InputStream args1) { return ; }

    @Override
    public void updateAsciiStream(java.lang.String args0, java.io.InputStream args1, int args2) { return ; }

    @Override
    public void updateAsciiStream(java.lang.String args0, java.io.InputStream args1, long args2) { return ; }

    @Override
    public void updateAsciiStream(int args0, java.io.InputStream args1, int args2) { return ; }

    @Override
    public void updateBigDecimal(int args0, java.math.BigDecimal args1) { return ; }

    @Override
    public void updateBigDecimal(java.lang.String args0, java.math.BigDecimal args1) { return ; }

    @Override
    public void updateBinaryStream(int args0, java.io.InputStream args1, int args2) { return ; }

    @Override
    public void updateBinaryStream(java.lang.String args0, java.io.InputStream args1) { return ; }

    @Override
    public void updateBinaryStream(java.lang.String args0, java.io.InputStream args1, int args2) { return ; }

    @Override
    public void updateBinaryStream(int args0, java.io.InputStream args1) { return ; }

    @Override
    public void updateBinaryStream(java.lang.String args0, java.io.InputStream args1, long args2) { return ; }

    @Override
    public void updateBinaryStream(int args0, java.io.InputStream args1, long args2) { return ; }

    @Override
    public void updateBlob(int args0, java.sql.Blob args1) { return ; }

    @Override
    public void updateBlob(java.lang.String args0, java.sql.Blob args1) { return ; }

    @Override
    public void updateBlob(java.lang.String args0, java.io.InputStream args1) { return ; }

    @Override
    public void updateBlob(java.lang.String args0, java.io.InputStream args1, long args2) { return ; }

    @Override
    public void updateBlob(int args0, java.io.InputStream args1) { return ; }

    @Override
    public void updateBlob(int args0, java.io.InputStream args1, long args2) { return ; }

    @Override
    public void updateBoolean(java.lang.String args0, boolean args1) { return ; }

    @Override
    public void updateBoolean(int args0, boolean args1) { return ; }

    @Override
    public void updateByte(int args0, byte args1) { return ; }

    @Override
    public void updateByte(java.lang.String args0, byte args1) { return ; }

    @Override
    public void updateCharacterStream(java.lang.String args0, java.io.Reader args1, int args2) { return ; }

    @Override
    public void updateCharacterStream(java.lang.String args0, java.io.Reader args1, long args2) { return ; }

    @Override
    public void updateCharacterStream(java.lang.String args0, java.io.Reader args1) { return ; }

    @Override
    public void updateCharacterStream(int args0, java.io.Reader args1, long args2) { return ; }

    @Override
    public void updateCharacterStream(int args0, java.io.Reader args1, int args2) { return ; }

    @Override
    public void updateCharacterStream(int args0, java.io.Reader args1) { return ; }

    @Override
    public void updateClob(java.lang.String args0, java.io.Reader args1, long args2) { return ; }

    @Override
    public void updateClob(int args0, java.io.Reader args1, long args2) { return ; }

    @Override
    public void updateClob(int args0, java.sql.Clob args1) { return ; }

    @Override
    public void updateClob(int args0, java.io.Reader args1) { return ; }

    @Override
    public void updateClob(java.lang.String args0, java.io.Reader args1) { return ; }

    @Override
    public void updateClob(java.lang.String args0, java.sql.Clob args1) { return ; }

    @Override
    public void updateDate(java.lang.String args0, java.sql.Date args1) { return ; }

    @Override
    public void updateDate(int args0, java.sql.Date args1) { return ; }

    @Override
    public void updateDouble(java.lang.String args0, double args1) { return ; }

    @Override
    public void updateDouble(int args0, double args1) { return ; }

    @Override
    public void updateFloat(java.lang.String args0, float args1) { return ; }

    @Override
    public void updateFloat(int args0, float args1) { return ; }

    @Override
    public void updateInt(int args0, int args1) { return ; }

    @Override
    public void updateInt(java.lang.String args0, int args1) { return ; }

    @Override
    public void updateLong(int args0, long args1) { return ; }

    @Override
    public void updateLong(java.lang.String args0, long args1) { return ; }

    @Override
    public void updateNCharacterStream(java.lang.String args0, java.io.Reader args1) { return ; }

    @Override
    public void updateNCharacterStream(int args0, java.io.Reader args1) { return ; }

    @Override
    public void updateNCharacterStream(int args0, java.io.Reader args1, long args2) { return ; }

    @Override
    public void updateNCharacterStream(java.lang.String args0, java.io.Reader args1, long args2) { return ; }

    @Override
    public void updateNClob(java.lang.String args0, java.io.Reader args1) { return ; }

    @Override
    public void updateNClob(java.lang.String args0, java.sql.NClob args1) { return ; }

    @Override
    public void updateNClob(java.lang.String args0, java.io.Reader args1, long args2) { return ; }

    @Override
    public void updateNClob(int args0, java.io.Reader args1, long args2) { return ; }

    @Override
    public void updateNClob(int args0, java.io.Reader args1) { return ; }

    @Override
    public void updateNClob(int args0, java.sql.NClob args1) { return ; }

    @Override
    public void updateNString(int args0, java.lang.String args1) { return ; }

    @Override
    public void updateNString(java.lang.String args0, java.lang.String args1) { return ; }

    @Override
    public void updateNull(java.lang.String args0) { return ; }

    @Override
    public void updateNull(int args0) { return ; }

    @Override
    public void updateObject(int args0, java.lang.Object args1) { return ; }

    @Override
    public void updateObject(java.lang.String args0, java.lang.Object args1) { return ; }

    @Override
    public void updateObject(java.lang.String args0, java.lang.Object args1, int args2) { return ; }

    @Override
    public void updateObject(int args0, java.lang.Object args1, int args2) { return ; }

    @Override
    public void updateRef(java.lang.String args0, java.sql.Ref args1) { return ; }

    @Override
    public void updateRef(int args0, java.sql.Ref args1) { return ; }

    @Override
    public void updateRow() { return ; }

    @Override
    public void updateRowId(int args0, java.sql.RowId args1) { return ; }

    @Override
    public void updateRowId(java.lang.String args0, java.sql.RowId args1) { return ; }

    @Override
    public void updateSQLXML(java.lang.String args0, java.sql.SQLXML args1) { return ; }

    @Override
    public void updateSQLXML(int args0, java.sql.SQLXML args1) { return ; }

    @Override
    public void updateShort(java.lang.String args0, short args1) { return ; }

    @Override
    public void updateShort(int args0, short args1) { return ; }

    @Override
    public void updateString(int args0, java.lang.String args1) { return ; }

    @Override
    public void updateString(java.lang.String args0, java.lang.String args1) { return ; }

    @Override
    public void updateTime(int args0, java.sql.Time args1) { return ; }

    @Override
    public void updateTime(java.lang.String args0, java.sql.Time args1) { return ; }

    @Override
    public void updateTimestamp(java.lang.String args0, java.sql.Timestamp args1) { return ; }

    @Override
    public void updateTimestamp(int args0, java.sql.Timestamp args1) { return ; }

    @Override
    public boolean wasNull() { return true; }

    @Override
    public boolean isFirst() { return true; }

    @Override
    public java.sql.Statement getStatement() { return null; }

    @Override
    public java.lang.Object unwrap(java.lang.Class args0) { return null; }

    @Override
    public boolean isWrapperFor(java.lang.Class args0) { return true; }

    @Override
    public int[] getMatchColumnIndexes() { return null; }

    @Override
    public java.lang.String[] getMatchColumnNames() { return null; }

    @Override
    public void setMatchColumn(int args0) { return ; }

    @Override
    public void setMatchColumn(java.lang.String[] args0) { return ; }

    @Override
    public void setMatchColumn(java.lang.String args0) { return ; }

    @Override
    public void setMatchColumn(int[] args0) { return ; }

    @Override
    public void unsetMatchColumn(java.lang.String args0) { return ; }

    @Override
    public void unsetMatchColumn(java.lang.String[] args0) { return ; }

    @Override
    public void unsetMatchColumn(int[] args0) { return ; }

    @Override
    public void unsetMatchColumn(int args0) { return ; }

}