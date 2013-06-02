package br.edu.fei.jarjarbinks.logic;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import br.edu.fei.jarjarbinks.CPU;
import br.edu.fei.jarjarbinks.exception.InvalidVarSize;
import br.edu.fei.jarjarbinks.instructions.Instruction;

public class ControlUnit {
	
	public void fetch() throws InvalidVarSize{
		CPU.mar.setWord(CPU.pc.getWord());
		CPU.mem.load();
		CPU.pc.nextInst();
	}
	
	
	
	public Instruction decode(){
		
		Instruction inst = null;
		try{
			for(Class clazz: this.getClasses("br.edu.fei.jarjarbinks.instructions.impl")){
				inst = (Instruction) clazz.newInstance();
				if(inst.checkResponsability()){
					return inst;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	private void execute(Instruction inst) {
		try{
			inst.execute();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void executeNextInst() throws InvalidVarSize{
		
		fetch();
		Instruction inst = decode();
		execute(inst);
	}

	/**
	 * Scans all classes accessible from the context class loader which belong to the given package and subpackages.
	 *
	 * @param packageName The base package
	 * @return The classes
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	private static Class[] getClasses(String packageName)
	        throws ClassNotFoundException, IOException {
	    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
	    assert classLoader != null;
	    String path = packageName.replace('.', '/');
	    Enumeration<URL> resources = classLoader.getResources(path);
	    List<File> dirs = new ArrayList<File>();
	    while (resources.hasMoreElements()) {
	        URL resource = resources.nextElement();
	        dirs.add(new File(resource.getFile()));
	    }
	    ArrayList<Class> classes = new ArrayList<Class>();
	    for (File directory : dirs) {
	        classes.addAll(findClasses(directory, packageName));
	    }
	    return classes.toArray(new Class[classes.size()]);
	}

	/**
	 * Recursive method used to find all classes in a given directory and subdirs.
	 *
	 * @param directory   The base directory
	 * @param packageName The package name for classes found inside the base directory
	 * @return The classes
	 * @throws ClassNotFoundException
	 */
	private static List<Class> findClasses(File directory, String packageName) throws ClassNotFoundException {
	    List<Class> classes = new ArrayList<Class>();
	    if (!directory.exists()) {
	        return classes;
	    }
	    File[] files = directory.listFiles();
	    for (File file : files) {
	        if (file.isDirectory()) {
	            assert !file.getName().contains(".");
	            classes.addAll(findClasses(file, packageName + "." + file.getName()));
	        } else if (file.getName().endsWith(".class")) {
	            classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
	        }
	    }
	    return classes;
	}

}
