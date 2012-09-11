package interpret.utility;

import java.awt.Point;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class UtilityClass {

	public static List<Object> findSubList(final List<Object> list, final Class<?> klass){
		final List<Object> subList = new LinkedList<Object>();
		for(int i = 0; i < list.size(); i++){
			final Object obj = list.get(i);
			if(klass.isInstance(obj)){
				subList.add(obj);
			}
		}

		subList.add("null");
		return subList;
	}


	public static Object convertValue(final Class<?> parameterType, final Object value){
		if(! parameterType.isPrimitive()){
			//if(value.getClass() == String.class && parameterType != String.class){
			if(value.getClass() == String.class){
				try{
					return getArrayElement((String)value);
				}catch(final Exception e){
					//ExceptionProcessor.processException(e);
				}
			}
			return value;
		}

		final String stringValue = (String)value;


		try{
			return getArrayElement(stringValue);
		}catch(final Exception e){
			//ExceptionProcessor.processException(e);
		}

		if(parameterType == char.class){
			if(stringValue.length() > 1){
				throw new  IllegalArgumentException("char should not be longer than 1.");
			}else{
				return new Character(stringValue.charAt(0));
			}
		}else{

			final Class<?> wrapClass = UtilityClass.getWrapClass(parameterType);
			final Constructor<?> constructor;

			try {
				constructor = wrapClass.getConstructor(String.class);
				return constructor.newInstance(stringValue);
			} catch (final Exception e) {
				ExceptionProcessor.processException(e);
			}

			return null;
		}

	}


	public static Class<?> getWrapClass(final Class<?> primitiveType){
		Class<?> wrapType;

		if(primitiveType == byte.class){
			wrapType = Byte.class;
		}else if(primitiveType == short.class){
			wrapType = Short.class;
		}else if(primitiveType == char.class){
			wrapType = Character.class;
		}else if(primitiveType == int.class){
			wrapType = Integer.class;
		}else if(primitiveType == long.class){
			wrapType = Long.class;
		}else if(primitiveType == float.class){
			wrapType = Float.class;
		}else if(primitiveType == double.class){
			wrapType = Double.class;
		}else if(primitiveType == boolean.class){
			wrapType = Boolean.class;
		}else{
			throw new IllegalArgumentException();
		}

		return wrapType;
	}


	static List<Object> objectList = null;
	public static List<Object> createObjectList(){
		if(objectList != null){
			return objectList;
		}

		objectList = new LinkedList<Object>();

		objectList.add(new Integer(5));
		objectList.add(new Long(1983L));
		objectList.add(new Double(6.6));
		objectList.add(new Point(1,2));
		objectList.add(new Boolean(true));

		return objectList;
	}


	public static void setStaticFinalField(final Object object, final Field staticFinalField, final Object value){
		try {
			staticFinalField.setAccessible(true);

			final Field modifiersField = Field.class.getDeclaredField("modifiers");
			modifiersField.setAccessible(true);
			int modifiers = modifiersField.getInt(staticFinalField);
			// blank out the final bit in the modifiers int
			modifiers &= ~Modifier.FINAL;
			modifiersField.setInt(staticFinalField, modifiers);

			staticFinalField.set(object, value);
		} catch (final Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public static ArrayList<Integer> removeFinalAccessor(final Field[] fields){
		final ArrayList<Integer> finalRemovedIndexList = new ArrayList<Integer>();

		for(int i = 0; i < fields.length; i++){
			final Field field = fields[i];
			try {
				field.setAccessible(true);

				final Field modifiersField = Field.class.getDeclaredField("modifiers");
				modifiersField.setAccessible(true);
				int modifiers = modifiersField.getInt(field);
				// blank out the final bit in the modifiers int
				if( (modifiers & Modifier.FINAL) != 0){
					finalRemovedIndexList.add(i);
				}
				modifiers &= ~Modifier.FINAL;
				modifiersField.setInt(field, modifiers);
			} catch (final Exception e) {
				ExceptionProcessor.processException(e);
			}
		}

		return finalRemovedIndexList;
	}


	public static Method[] getNecessaryMethods(final Class<?> klass){
		if(klass == null){
			return null;
		}

		final Set<Method> methodSet = new LinkedHashSet<Method>();
		final Method[] declaredMethods = klass.getDeclaredMethods();
		final Method[] publicMethods = klass.getMethods();

		for(final Method declaredMethod : declaredMethods){
			methodSet.add(declaredMethod);
		}

		for(final Method publicMethod : publicMethods){
			methodSet.add(publicMethod);
		}

		final Object[] necessaryObjects = methodSet.toArray();
		final Method[] necessaryMethods =new Method[necessaryObjects.length];
		for(int i = 0; i < necessaryObjects.length; i++){
			necessaryMethods[i] = (Method)necessaryObjects[i];
		}

		return necessaryMethods;

	}


	public static Field[] getNecessaryFields(final Class<?> klass){
		if(klass == null){
			return null;
		}

		final Set<Field> fieldSet = new LinkedHashSet<Field>();
		final Field[] declaredFields = klass.getDeclaredFields();
		final Field[] publicFields = klass.getFields();

		for(final Field declaredField : declaredFields){
			fieldSet.add(declaredField);
		}

		for(final Field publicField : publicFields){
			fieldSet.add(publicField);
		}

		final Object[] necessaryObjects = fieldSet.toArray();
		final Field[] necessaryFields =new Field[necessaryObjects.length];
		for(int i = 0; i < necessaryObjects.length; i++){
			necessaryFields[i] = (Field)necessaryObjects[i];
		}

		return necessaryFields;

	}


	public static Class<?> getPrimitiveTypeClass(final String className){

		if("byte".equals(className)){
			return byte.class;
		}else if("short".equals(className)){
			return short.class;
		}else if("char".equals(className)){
			return char.class;
		}else if("int".equals(className)){
			return int.class;
		}else if("long".equals(className)){
			return long.class;
		}else if("float".equals(className)){
			return float.class;
		}else if("double".equals(className)){
			return double.class;
		}else if("boolean".equals(className)){
			return boolean.class;
		}else{
			return null;
		}
	}


	public static Object changeArrayLength(final Object oldArray, final int newLength) {
		final Class<?> c = oldArray.getClass();
		if (!c.isArray() || newLength < 0){
			return null;
		}
		final Class<?> componentType = c.getComponentType();

		final int oldLength = Array.getLength(oldArray);
		final int copyLength = newLength <= oldLength ? newLength : oldLength;

		final Object newArray = Array.newInstance(componentType, newLength);
		System.arraycopy(oldArray, 0, newArray, 0, copyLength);
		return newArray;
	}


	public static String arrayToString(final Object arrayObject){
		if(	arrayObject.getClass().isArray() == false){
			return null;
		}

		if(arrayObject.getClass().getComponentType().isPrimitive() == false){
			return Arrays.toString((Object[])arrayObject);
		}

		final int size = Array.getLength(arrayObject);
		final Object[] newArray = new Object[size];
		for(int i = 0; i < size; i++){
			newArray[i] = Array.get(arrayObject, i);
		}
		return Arrays.toString(newArray);

	}


	private static Object getArrayElement(final String arrayElementString){
		final String[] splitResult = arrayElementString.split("#");
		final int objectIndex = Integer.valueOf(splitResult[0]);
		final int arrayIndex = Integer.valueOf(splitResult[1]);

		final List<Object> objectList = createObjectList();
		final Object arrayObject = objectList.get(objectIndex);

		final Object arrayElement = Array.get(arrayObject, arrayIndex);
		return arrayElement;
	}
}