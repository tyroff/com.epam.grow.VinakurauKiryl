package com.epam.validation.utils;

import com.epam.validation.entities.Address;
import com.epam.validation.entities.User;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Performs validation of the {@link com.epam.validation.entities.User} and {@link com.epam.validation.entities.Address} classes.
 *
 * @author Kiryl_Vinakurau
 */
public class ValidationService {

    /**
     * Compares the fields of the incoming Address object with the fields of the {@link com.epam.validation.entities.Address} Class.
     * @param address is an object, its fields must be checked against the fields of the {@link com.epam.validation.entities.Address} class.
     * @return true if the parameter values match.
     */
    public boolean validate(Address address) {
        Class<Address> addressClass = Address.class;
        Class<Address> receivedAddress = (Class<Address>) address.getClass();
        Field[] fieldsAddressClass = addressClass.getDeclaredFields();
        Field[] fieldsReceivedAddress = receivedAddress.getDeclaredFields();

        isFalse:
        {
            for (Field fieldAddressClass : fieldsAddressClass) {
                String nameFieldAddressClass = fieldAddressClass.getName();
                Class<?> typeFieldAddressClass = fieldAddressClass.getType();

                if (!fieldAddressClass.isAccessible()) {
                    fieldAddressClass.setAccessible(true);
                }

                for (Field fieldReceivedAddress : fieldsReceivedAddress) {
                    String nameFieldReceivedAddress = fieldReceivedAddress.getName();
                    Class<?> typeFieldReceivedAddress = fieldReceivedAddress.getType();

                    if (!fieldReceivedAddress.isAccessible()) {
                        fieldReceivedAddress.setAccessible(true);
                    }

                    if (typeFieldAddressClass == typeFieldReceivedAddress && nameFieldAddressClass.equals(nameFieldReceivedAddress)) {
                        try {
                            if (typeFieldReceivedAddress.isPrimitive()) {
                                if (typeFieldReceivedAddress == Byte.TYPE) {
                                    Method method = receivedAddress.getMethod("isValid", String.class, byte.class);
                                    method.setAccessible(true);
                                    if (!(boolean) method.invoke(address, nameFieldReceivedAddress,
                                            fieldReceivedAddress.getByte(address))) break isFalse;
                                } else if (typeFieldReceivedAddress == Short.TYPE) {
                                    Method method = receivedAddress.getMethod("isValid", String.class, short.class);
                                    method.setAccessible(true);
                                    if (!(boolean) method.invoke(address, nameFieldReceivedAddress,
                                            fieldReceivedAddress.getShort(address))) break isFalse;
                                } else if (typeFieldReceivedAddress == Integer.TYPE) {
                                    Method method = receivedAddress.getMethod("isValid", String.class, int.class);
                                    method.setAccessible(true);
                                    if (!(boolean) method.invoke(address, nameFieldReceivedAddress,
                                            fieldReceivedAddress.getInt(address))) break isFalse;
                                } else if (typeFieldReceivedAddress == Long.TYPE) {
                                    Method method = receivedAddress.getMethod("isValid", String.class, long.class);
                                    method.setAccessible(true);
                                    if (!(boolean) method.invoke(address, nameFieldReceivedAddress,
                                            fieldReceivedAddress.getLong(address))) break isFalse;
                                } else if (typeFieldReceivedAddress == Float.TYPE) {
                                    Method method = receivedAddress.getMethod("isValid", String.class, float.class);
                                    method.setAccessible(true);
                                    if (!(boolean) method.invoke(address, nameFieldReceivedAddress,
                                            fieldReceivedAddress.getFloat(address))) break isFalse;
                                } else if (typeFieldReceivedAddress == Double.TYPE) {
                                    Method method = receivedAddress.getMethod("isValid", String.class, double.class);
                                    method.setAccessible(true);
                                    if (!(boolean) method.invoke(address, nameFieldReceivedAddress,
                                            fieldReceivedAddress.getDouble(address))) break isFalse;
                                }
                            } else if (typeFieldReceivedAddress == String.class) {
                                if (fieldReceivedAddress.get(address) == null) break isFalse;
                                Method method = receivedAddress.getMethod("isValid", String.class, String.class);
                                method.setAccessible(true);
                                if (!(boolean) method.invoke(address, nameFieldReceivedAddress,
                                        (String) fieldReceivedAddress.get(address))) break isFalse;
                            } else if (typeFieldReceivedAddress instanceof Object) {
                                if (fieldReceivedAddress.get(address) == null) break isFalse;
                                Method method = receivedAddress.getMethod("isValid", String.class, Object.class);
                                method.setAccessible(true);
                                if (!(boolean) method.invoke(address, nameFieldReceivedAddress,
                                        (Object) fieldReceivedAddress.get(address))) break isFalse;
                            }
                        } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        } catch (NullPointerException e) {
                            e.printStackTrace();
                        } catch (ExceptionInInitializerError e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Compares the fields of the incoming Address object with the fields of the {@link com.epam.validation.entities.User} Class.
     * @param user is an object, its fields must be checked against the fields of the {@link com.epam.validation.entities.User} class.
     * @return true if the parameter values match.
     */
    public boolean validate(User user) {
        Class<User> userClass = User.class;
        Class<User> receivedUser = (Class<User>) user.getClass();
        Field[] fieldsUserClass = userClass.getDeclaredFields();
        Field[] fieldsReceivedUser = receivedUser.getDeclaredFields();

        isFalse:
        {
            for (Field fieldUserClass : fieldsUserClass) {
                String nameFieldUserClass = fieldUserClass.getName();
                Class<?> typeFieldUserClass = fieldUserClass.getType();

                if (!fieldUserClass.isAccessible()) {
                    fieldUserClass.setAccessible(true);
                }

                for (Field fieldReceivedUser : fieldsReceivedUser) {
                    String nameFieldReceivedUser = fieldReceivedUser.getName();
                    Class<?> typeFieldReceivedUser = fieldReceivedUser.getType();

                    if (!fieldReceivedUser.isAccessible()) {
                        fieldReceivedUser.setAccessible(true);
                    }

                    if (typeFieldUserClass == typeFieldReceivedUser && nameFieldUserClass.equals(nameFieldReceivedUser)) {
                        try {
                            if (typeFieldReceivedUser.isPrimitive()) {
                                if (typeFieldReceivedUser == Byte.TYPE) {
                                    Method method = receivedUser.getMethod("isValid", String.class, byte.class);
                                    method.setAccessible(true);
                                    if (!(boolean) method.invoke(user, nameFieldReceivedUser,
                                            fieldReceivedUser.getByte(user))) break isFalse;
                                } else if (typeFieldReceivedUser == Short.TYPE) {
                                    Method method = receivedUser.getMethod("isValid", String.class, short.class);
                                    method.setAccessible(true);
                                    if (!(boolean) method.invoke(user, nameFieldReceivedUser,
                                            fieldReceivedUser.getShort(user))) break isFalse;
                                } else if (typeFieldReceivedUser == Integer.TYPE) {
                                    Method method = receivedUser.getMethod("isValid", String.class, int.class);
                                    method.setAccessible(true);
                                    if (!(boolean) method.invoke(user, nameFieldReceivedUser,
                                            fieldReceivedUser.getInt(user))) break isFalse;
                                } else if (typeFieldReceivedUser == Long.TYPE) {
                                    Method method = receivedUser.getMethod("isValid", String.class, long.class);
                                    method.setAccessible(true);
                                    if (!(boolean) method.invoke(user, nameFieldReceivedUser,
                                            fieldReceivedUser.getLong(user))) break isFalse;
                                } else if (typeFieldReceivedUser == Float.TYPE) {
                                    Method method = receivedUser.getMethod("isValid", String.class, float.class);
                                    method.setAccessible(true);
                                    if (!(boolean) method.invoke(user, nameFieldReceivedUser,
                                            fieldReceivedUser.getFloat(user))) break isFalse;
                                } else if (typeFieldReceivedUser == Double.TYPE) {
                                    Method method = receivedUser.getMethod("isValid", String.class, double.class);
                                    method.setAccessible(true);
                                    if (!(boolean) method.invoke(user, nameFieldReceivedUser,
                                            fieldReceivedUser.getDouble(user))) break isFalse;
                                }
                            } else if (typeFieldReceivedUser == String.class) {
                                if (fieldReceivedUser.get(user) == null) break isFalse;
                                Method method = receivedUser.getMethod("isValid", String.class, String.class);
                                method.setAccessible(true);
                                if (!(boolean) method.invoke(user, nameFieldReceivedUser,
                                        (String) fieldReceivedUser.get(user))) break isFalse;
                            } else if (typeFieldReceivedUser == Address.class) {
                                if (!validate((Address) fieldReceivedUser.get(user))) break isFalse;
                            } else if (typeFieldReceivedUser instanceof Object) {
                                if (fieldReceivedUser.get(user) == null) break isFalse;
                                Method method = receivedUser.getMethod("isValid", String.class, Object.class);
                                method.setAccessible(true);
                                if (!(boolean) method.invoke(user, nameFieldReceivedUser,
                                        (Object) fieldReceivedUser.get(user))) {
                                    break isFalse;
                                }
                            }
                        } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        } catch (NullPointerException e) {
                            e.printStackTrace();
                        } catch (ExceptionInInitializerError e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }
}
