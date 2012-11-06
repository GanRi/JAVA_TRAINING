package ch16.ex09;

import java.lang.reflect.*;

public class CopyOfDeclaration {


	public static void main(String[] args) {
		try {
			Class<?> klass = Class.forName("ch16.ex16_09.Test");
			
//			System.out.print(Modifier.toString(c.getModifiers()) + " ");
//			System.out.print(c.getSimpleName());
//			TypeVariable[] typeVariables = c.getTypeParameters();
//			if(typeVariables.length > 0){
//				System.out.print(" <");
//				for(int i = 0; i < typeVariables.length; i++){
//					System.out.print(typeVariables[i].toString());
//					if(i != typeVariables.length -1){
//						System.out.print(", ");
//					}
//				}
//				System.out.println(">");
//			}
			
			System.out.println(getTypeDeclarationLine(klass, true));
			
//			printMembers(c.getFields());
//			printMembers(c.getConstructors());
//			printMembers(c.getMethods());
		} catch (ClassNotFoundException e) {
			System.out.println("unknown class: " + args[0]);
		}
	}

	private static void printMembers(Member[] mems) {
		for (Member m : mems) {
			if (m.getDeclaringClass() == Object.class)
				continue;
			String decl = m.toString();
			System.out.print(" ");
			//System.out.println(strip(decl, "java.lang."));
			System.out.println(decl);
		}
	}
	// ... definition of strip ...
	
	private static String removePackageName(String className, String packageName){
		return className.replace(packageName+".", "");
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
		
		if(isRawClass){
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
				sb.append(">");
			}	
		}else{
			Type[] actualTypes = ((ParameterizedType)type).getActualTypeArguments();
			if(actualTypes.length > 0){
				sb.append(" <");
				for(int i = 0; i < actualTypes.length; i++){
					
					if(actualTypes[i] instanceof WildcardType){
						
					}else if(actualTypes[i] instanceof TypeVariable ){
						
					}else{
						sb.append( getTypeDeclarationLine(actualTypes[i], false)) ;
					}
					
					if(i != actualTypes.length -1){
						sb.append(", ");
					}
					
				}
				sb.append(" <");
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

