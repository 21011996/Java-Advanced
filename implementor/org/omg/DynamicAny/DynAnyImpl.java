package org.omg.DynamicAny;

public class DynAnyImpl implements org.omg.DynamicAny.DynAny {

    @Override
    public org.omg.CORBA.TypeCode type() { return null; }

    @Override
    public boolean next() { return true; }

    @Override
    public void destroy() { return ; }

    @Override
    public org.omg.DynamicAny.DynAny copy() { return null; }

    @Override
    public void rewind() { return ; }

    @Override
    public void assign(org.omg.DynamicAny.DynAny args0) { return ; }

    @Override
    public boolean seek(int args0) { return true; }

    @Override
    public boolean equal(org.omg.DynamicAny.DynAny args0) { return true; }

    @Override
    public int component_count() { return 0; }

    @Override
    public org.omg.DynamicAny.DynAny current_component() { return null; }

    @Override
    public void from_any(org.omg.CORBA.Any args0) { return ; }

    @Override
    public org.omg.CORBA.Any get_any() { return null; }

    @Override
    public boolean get_boolean() { return true; }

    @Override
    public char get_char() { return 'a'; }

    @Override
    public double get_double() { return 0; }

    @Override
    public org.omg.DynamicAny.DynAny get_dyn_any() { return null; }

    @Override
    public float get_float() { return 0; }

    @Override
    public int get_long() { return 0; }

    @Override
    public long get_longlong() { return 0; }

    @Override
    public byte get_octet() { return 0; }

    @Override
    public org.omg.CORBA.Object get_reference() { return null; }

    @Override
    public short get_short() { return 0; }

    @Override
    public java.lang.String get_string() { return null; }

    @Override
    public org.omg.CORBA.TypeCode get_typecode() { return null; }

    @Override
    public int get_ulong() { return 0; }

    @Override
    public long get_ulonglong() { return 0; }

    @Override
    public short get_ushort() { return 0; }

    @Override
    public java.io.Serializable get_val() { return null; }

    @Override
    public char get_wchar() { return 'a'; }

    @Override
    public java.lang.String get_wstring() { return null; }

    @Override
    public void insert_any(org.omg.CORBA.Any args0) { return ; }

    @Override
    public void insert_boolean(boolean args0) { return ; }

    @Override
    public void insert_char(char args0) { return ; }

    @Override
    public void insert_double(double args0) { return ; }

    @Override
    public void insert_dyn_any(org.omg.DynamicAny.DynAny args0) { return ; }

    @Override
    public void insert_float(float args0) { return ; }

    @Override
    public void insert_long(int args0) { return ; }

    @Override
    public void insert_longlong(long args0) { return ; }

    @Override
    public void insert_octet(byte args0) { return ; }

    @Override
    public void insert_reference(org.omg.CORBA.Object args0) { return ; }

    @Override
    public void insert_short(short args0) { return ; }

    @Override
    public void insert_string(java.lang.String args0) { return ; }

    @Override
    public void insert_typecode(org.omg.CORBA.TypeCode args0) { return ; }

    @Override
    public void insert_ulong(int args0) { return ; }

    @Override
    public void insert_ulonglong(long args0) { return ; }

    @Override
    public void insert_ushort(short args0) { return ; }

    @Override
    public void insert_val(java.io.Serializable args0) { return ; }

    @Override
    public void insert_wchar(char args0) { return ; }

    @Override
    public void insert_wstring(java.lang.String args0) { return ; }

    @Override
    public org.omg.CORBA.Any to_any() { return null; }

    @Override
    public org.omg.CORBA.Request _create_request(org.omg.CORBA.Context args0, java.lang.String args1, org.omg.CORBA.NVList args2, org.omg.CORBA.NamedValue args3, org.omg.CORBA.ExceptionList args4, org.omg.CORBA.ContextList args5) { return null; }

    @Override
    public org.omg.CORBA.Request _create_request(org.omg.CORBA.Context args0, java.lang.String args1, org.omg.CORBA.NVList args2, org.omg.CORBA.NamedValue args3) { return null; }

    @Override
    public org.omg.CORBA.Object _duplicate() { return null; }

    @Override
    public org.omg.CORBA.DomainManager[] _get_domain_managers() { return null; }

    @Override
    public org.omg.CORBA.Object _get_interface_def() { return null; }

    @Override
    public org.omg.CORBA.Policy _get_policy(int args0) { return null; }

    @Override
    public int _hash(int args0) { return 0; }

    @Override
    public boolean _is_a(java.lang.String args0) { return true; }

    @Override
    public boolean _is_equivalent(org.omg.CORBA.Object args0) { return true; }

    @Override
    public boolean _non_existent() { return true; }

    @Override
    public void _release() { return ; }

    @Override
    public org.omg.CORBA.Request _request(java.lang.String args0) { return null; }

    @Override
    public org.omg.CORBA.Object _set_policy_override(org.omg.CORBA.Policy[] args0, org.omg.CORBA.SetOverrideType args1) { return null; }

}