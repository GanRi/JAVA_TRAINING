package ch16.ex09;

import java.lang.reflect.*;
import java.util.HashMap;

public class Declaration {


	public static void main(String[] args) {
		try {
			Class<?> klass = Class.forName("ch16.ex16_09.Test");
			
			System.out.println(getTypeDeclarationLine(klass, true));
			
			printMembers(klass.getDeclaredFields());
			printMembers(klass.getDeclaredConstructors());
			printMembers(klass.getDeclaredMethods());
		} catch (ClassNotFoundException e) {
			System.out.println("unknown class: " + args[0]);
		}
	}

	private static void printMembers(Member[] mems) {
		for (Member m : mems) {
			if (m.getDeclaringClass() == Object.class)
				continue;
			String decl = m.toString();
			System.out.print("\t");
			decl = strip(decl, m.getDeclaringClass().getCanonicalName()+".");
			decl = strip(decl, "java.lang.");
			decl = strip(decl, m.getDeclaringClass().getPackage().getName()+".");
			System.out.println(decl);
		}
		
		System.out.println();
	}
	
	
	// ... definition of strip ...

	
	
	
	
	private static String removePackageName(String className, String packageName){
		return className.replace(packageName+".", "");
	}
	
	
	private static String strip(String src, String target){
		return src.replace(target, "");
	}

//	private static String typeVariableToString(TypeVariable typeVariable){
//		
//	}
	
	
	
	
	@SuppressWarnings("unchecked")
	public static String getTypeDeclarationLine(Type type, boolean full){
		Class<?> klass = null;
		StringBuffer sb = new StringBuffer();
		boolean isRawClass = true;
		
		
		if(type instanceof Class<?>){
			klass = (Class<?>)type;
			isRawClass = true;
		}else if(type instanceof ParameterizedType){
			klass = (Class<?>) ((ParameterizedType)type).getRawType();
			isRawClass = false;
		}else{
			throw new Error("Unexpected non-class type");
		}
		
		if(full){
			sb.append(Modifier.toString(klass.getModifiers()) + " class ");
		}

		sb.append(klass.getSimpleName());
		TypeVariable[] typeVariables = klass.getTypeParameters();
		if(typeVariables.length > 0){
			sb.append(" <");
			for(int i = 0; i < typeVariables.length; i++){
				//sb.append(typeVariables[i].toString());
				sb.append(getTypeVariableFullString(typeVariables[i]));
				if(i != typeVariables.length -1){
					sb.append(", ");
				}
			}
			sb.append("> ");
		}	
		
		
		if(full){
			Type superClass = klass.getGenericSuperclass();
			if(superClass != Object.class){
				sb.append(" extends " + ((Class<?>)superClass).getSimpleName() + " ");
			}
			
			Type[] interfaces = klass.getGenericInterfaces();
			if(interfaces.length > 0){
				sb.append("implements ");
				for(int i = 0; i < interfaces.length; i++){
					sb.append(((Class<?>)interfaces[i]).getSimpleName());
					if(i != interfaces.length -1){
						sb.append(", ");
					}
				}
			}
		}
		
		
		return sb.toString();
	}
	
	
	@SuppressWarnings("unchecked")
	public static String getTypeVariableFullString(TypeVariable typeVariable){
		StringBuffer sb = new StringBuffer();
		
		sb.append(typeVariable.getName() + " ");
		Type[] bounds = typeVariable.getBounds();
		if(bounds.length > 0){
			if(bounds.length == 1 && bounds[0] == Object.class){
				return sb.toString();
			}
			
			sb.append("extends ");
			for(int i = 0; i < bounds.length; i++){
				
				sb.append(getTypeDeclarationLine(bounds[i], false));
				if(i != bounds.length - 1){
					sb.append(" & ");
				}
			}
			
		}
		
		return sb.toString();
		
	}
	
}

