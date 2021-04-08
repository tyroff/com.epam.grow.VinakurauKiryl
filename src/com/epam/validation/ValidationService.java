package com.epam.validation;

import java.lang.reflect.Field;

public class ValidationService {

    public boolean validate(Address address) {
        Class<Address> addressClass = Address.class;
        Class<Address> receivedAddress = (Class<Address>) address.getClass();
        Field[] fieldAddressClass = addressClass.getDeclaredFields();
        Field[] fieldReceivedAddress = receivedAddress.getDeclaredFields();

        for (int i = 0; i < fieldAddressClass.length; i++) {
            String nameFieldAddressClass = fieldAddressClass[i].getName();
            Class<?> typeFieldAddressClass = fieldAddressClass[i].getType();

            if(!fieldAddressClass[i].isAccessible()){
                fieldAddressClass[i].setAccessible(true);
            }

            for (int j = 0; j < fieldReceivedAddress.length; j++) {
                String nameFieldReceivedAddress = fieldReceivedAddress[j].getName();
                Class<?> typeFieldReceivedAddress = fieldReceivedAddress[j].getType();

                if(!fieldReceivedAddress[j].isAccessible()){
                    fieldReceivedAddress[j].setAccessible(true);
                }

                if (typeFieldAddressClass == typeFieldReceivedAddress && nameFieldAddressClass.equals(nameFieldReceivedAddress)) {
                    try {
                        if (typeFieldReceivedAddress.isPrimitive()) {
                            if (typeFieldReceivedAddress == Byte.TYPE && fieldReceivedAddress[j].getByte(address) <= 0) {
                                return false;
                            } else if (typeFieldReceivedAddress == Short.TYPE && fieldReceivedAddress[j].getShort(address) <= 0) {
                                return false;
                            } else if (typeFieldReceivedAddress == Integer.TYPE && fieldReceivedAddress[j].getInt(address) <= 0) {
                                return false;
                            } else if (typeFieldReceivedAddress == Long.TYPE && fieldReceivedAddress[j].getLong(address) <= 0) {
                                return false;
                            } else if (typeFieldReceivedAddress == Float.TYPE && fieldReceivedAddress[j].getFloat(address) <= 0.0f) {
                                return false;
                            } else if (typeFieldReceivedAddress == Double.TYPE && fieldReceivedAddress[j].getDouble(address) <= 0.0d) {
                                return false;
                            }
                        } else if (typeFieldReceivedAddress == String.class) {
                            if (((String) fieldReceivedAddress[j].get(address)) == null) {
                                return false;
                            }
                        } else if (typeFieldReceivedAddress instanceof Object) {
                            if ((fieldReceivedAddress[j].get(address)) == null) {
                                return false;
                            }
                        }
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return true;
    }

    public boolean validate(User user) {
        Class<User> userClass = User.class;
        Class<User> receivedUser = (Class<User>) user.getClass();
        Field[] fieldUserClass = userClass.getDeclaredFields();
        Field[] fieldReceivedUser = receivedUser.getDeclaredFields();

        for (int i = 0; i < fieldUserClass.length; i++) {
            String nameFieldUserClass = fieldUserClass[i].getName();
            Class<?> typeFieldUserClass = fieldUserClass[i].getType();

            if(!fieldUserClass[i].isAccessible()){
                fieldUserClass[i].setAccessible(true);
            }

            for (int j = 0; j < fieldReceivedUser.length; j++) {
                String nameFieldReceivedUser = fieldReceivedUser[j].getName();
                Class<?> typeFieldReceivedUser = fieldReceivedUser[j].getType();
                fieldReceivedUser[j].setAccessible(true);

                if(!fieldReceivedUser[j].isAccessible()){
                    fieldReceivedUser[j].setAccessible(true);
                }

                if (typeFieldUserClass == typeFieldReceivedUser && nameFieldUserClass.equals(nameFieldReceivedUser)) {
                    try {
                        if (typeFieldReceivedUser.isPrimitive()) {
                            if (typeFieldReceivedUser == Byte.TYPE && fieldReceivedUser[j].getByte(user) <= 0) {
                                return false;
                            } else if (typeFieldReceivedUser == Short.TYPE && fieldReceivedUser[j].getShort(user) <= 0) {
                                return false;
                            } else if (typeFieldReceivedUser == Integer.TYPE && fieldReceivedUser[j].getInt(user) <= 0) {
                                return false;
                            } else if (typeFieldReceivedUser == Long.TYPE && fieldReceivedUser[j].getLong(user) <= 0) {
                                return false;
                            } else if (typeFieldReceivedUser == Float.TYPE && fieldReceivedUser[j].getFloat(user) <= 0.0f) {
                                return false;
                            } else if (typeFieldReceivedUser == Double.TYPE && fieldReceivedUser[j].getDouble(user) <= 0.0d) {
                                return false;
                            }
                        } else if (typeFieldReceivedUser == String.class) {
                            if (((String) fieldReceivedUser[j].get(user)) == null) {
                                return false;
                            }
                        } else if (typeFieldReceivedUser == Address.class) {
                            if (nameFieldReceivedUser == "address") {
                                return validate((Address) fieldReceivedUser[j].get(user));
                            }
                        } else if (typeFieldReceivedUser instanceof Object) {
                            if ((fieldReceivedUser[j].get(user)) == null) {
                                return false;
                            }
                        }
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return true;
    }
}
