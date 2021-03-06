/*
 * MATLAB Compiler: 4.18.1 (R2013a)
 * Date: Thu Oct 30 21:11:24 2014
 * Arguments: "-B" "macro_default" "-W" "java:Arbitrage_Main,Arbitrage_Main" "-T" 
 * "link:lib" "-d" "E:\\nju\\2014���챭\\fxy\\Arbitrage_Main\\src" "-w" 
 * "enable:specified_file_mismatch" "-w" "enable:repeated_file" "-w" 
 * "enable:switch_ignored" "-w" "enable:missing_lib_sentinel" "-w" "enable:demo_license" 
 * "-v" "class{Arbitrage_Main:E:\\nju\\2014���챭\\fxy\\Arbitrage_Main.m}" 
 * "class{Open:E:\\nju\\2014���챭\\fxy\\open.m}" 
 * "class{Close:E:\\nju\\2014���챭\\fxy\\close.m}" 
 * "class{getFlen:E:\\nju\\2014���챭\\fxy\\mygetFlen.m}" "-a" 
 * "E:\\nju\\2014���챭\\fxy\\Arbitrage_Main.m" "-a" 
 * "E:\\nju\\2014���챭\\fxy\\arbitrage_return.m" "-a" 
 * "E:\\nju\\2014���챭\\fxy\\bias_ratio.m" "-a" "E:\\nju\\2014���챭\\fxy\\close.m" "-a" 
 * "E:\\nju\\2014���챭\\fxy\\max_occupying_fund.m" "-a" 
 * "E:\\nju\\2014���챭\\fxy\\mygetFlen.m" "-a" "E:\\nju\\2014���챭\\fxy\\open.m" 
 */

package Arbitrage_Main;

import com.mathworks.toolbox.javabuilder.*;
import com.mathworks.toolbox.javabuilder.internal.*;
import java.util.*;

/**
 * The <code>getFlen</code> class provides a Java interface to the M-functions
 * from the files:
 * <pre>
 *  E:\\nju\\2014���챭\\fxy\\mygetFlen.m
 * </pre>
 * The {@link #dispose} method <b>must</b> be called on a <code>getFlen</code> instance 
 * when it is no longer needed to ensure that native resources allocated by this class 
 * are properly freed.
 * @version 0.0
 */
public class getFlen extends MWComponentInstance<getFlen>
{
    /**
     * Tracks all instances of this class to ensure their dispose method is
     * called on shutdown.
     */
    private static final Set<Disposable> sInstances = new HashSet<Disposable>();

    /**
     * Maintains information used in calling the <code>mygetFlen</code> M-function.
     */
    private static final MWFunctionSignature sMygetFlenSignature =
        new MWFunctionSignature(/* max outputs = */ 2,
                                /* has varargout = */ false,
                                /* function name = */ "mygetFlen",
                                /* max inputs = */ 2,
                                /* has varargin = */ false);

    /**
     * Shared initialization implementation - private
     */
    private getFlen (final MWMCR mcr) throws MWException
    {
        super(mcr);
        // add this to sInstances
        synchronized(getFlen.class) {
            sInstances.add(this);
        }
    }

    /**
     * Constructs a new instance of the <code>getFlen</code> class.
     */
    public getFlen() throws MWException
    {
        this(Arbitrage_MainMCRFactory.newInstance());
    }
    
    private static MWComponentOptions getPathToComponentOptions(String path)
    {
        MWComponentOptions options = new MWComponentOptions(new MWCtfExtractLocation(path),
                                                            new MWCtfDirectorySource(path));
        return options;
    }
    
    /**
     * @deprecated Please use the constructor {@link #getFlen(MWComponentOptions componentOptions)}.
     * The <code>com.mathworks.toolbox.javabuilder.MWComponentOptions</code> class provides API to set the
     * path to the component.
     * @param pathToComponent Path to component directory.
     */
    public getFlen(String pathToComponent) throws MWException
    {
        this(Arbitrage_MainMCRFactory.newInstance(getPathToComponentOptions(pathToComponent)));
    }
    
    /**
     * Constructs a new instance of the <code>getFlen</code> class. Use this constructor 
     * to specify the options required to instantiate this component.  The options will 
     * be specific to the instance of this component being created.
     * @param componentOptions Options specific to the component.
     */
    public getFlen(MWComponentOptions componentOptions) throws MWException
    {
        this(Arbitrage_MainMCRFactory.newInstance(componentOptions));
    }
    
    /** Frees native resources associated with this object */
    public void dispose()
    {
        try {
            super.dispose();
        } finally {
            synchronized(getFlen.class) {
                sInstances.remove(this);
            }
        }
    }
  
    /**
     * Invokes the first m-function specified by MCC, with any arguments given on
     * the command line, and prints the result.
     */
    public static void main (String[] args)
    {
        try {
            MWMCR mcr = Arbitrage_MainMCRFactory.newInstance();
            mcr.runMain( sMygetFlenSignature, args);
            mcr.dispose();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
    
    /**
     * Calls dispose method for each outstanding instance of this class.
     */
    public static void disposeAllInstances()
    {
        synchronized(getFlen.class) {
            for (Disposable i : sInstances) i.dispose();
            sInstances.clear();
        }
    }

    /**
     * Provides the interface for calling the <code>mygetFlen</code> M-function 
     * where the first input, an instance of List, receives the output of the M-function and
     * the second input, also an instance of List, provides the input to the M-function.
     * <p>M-documentation as provided by the author of the M function:
     * <pre>
     * %GETFLEN Summary of this function goes here
     * %   Detailed explanation goes here
     * </pre>
     * </p>
     * @param lhs List in which to return outputs. Number of outputs (nargout) is
     * determined by allocated size of this List. Outputs are returned as
     * sub-classes of <code>com.mathworks.toolbox.javabuilder.MWArray</code>.
     * Each output array should be freed by calling its <code>dispose()</code>
     * method.
     *
     * @param rhs List containing inputs. Number of inputs (nargin) is determined
     * by the allocated size of this List. Input arguments may be passed as
     * sub-classes of <code>com.mathworks.toolbox.javabuilder.MWArray</code>, or
     * as arrays of any supported Java type. Arguments passed as Java types are
     * converted to MATLAB arrays according to default conversion rules.
     * @throws MWException An error has occurred during the function call.
     */
    public void mygetFlen(List lhs, List rhs) throws MWException
    {
        fMCR.invoke(lhs, rhs, sMygetFlenSignature);
    }

    /**
     * Provides the interface for calling the <code>mygetFlen</code> M-function 
     * where the first input, an Object array, receives the output of the M-function and
     * the second input, also an Object array, provides the input to the M-function.
     * <p>M-documentation as provided by the author of the M function:
     * <pre>
     * %GETFLEN Summary of this function goes here
     * %   Detailed explanation goes here
     * </pre>
     * </p>
     * @param lhs array in which to return outputs. Number of outputs (nargout)
     * is determined by allocated size of this array. Outputs are returned as
     * sub-classes of <code>com.mathworks.toolbox.javabuilder.MWArray</code>.
     * Each output array should be freed by calling its <code>dispose()</code>
     * method.
     *
     * @param rhs array containing inputs. Number of inputs (nargin) is
     * determined by the allocated size of this array. Input arguments may be
     * passed as sub-classes of
     * <code>com.mathworks.toolbox.javabuilder.MWArray</code>, or as arrays of
     * any supported Java type. Arguments passed as Java types are converted to
     * MATLAB arrays according to default conversion rules.
     * @throws MWException An error has occurred during the function call.
     */
    public void mygetFlen(Object[] lhs, Object[] rhs) throws MWException
    {
        fMCR.invoke(Arrays.asList(lhs), Arrays.asList(rhs), sMygetFlenSignature);
    }

    /**
     * Provides the standard interface for calling the <code>mygetFlen</code>
     * M-function with 2 input arguments.
     * Input arguments may be passed as sub-classes of
     * <code>com.mathworks.toolbox.javabuilder.MWArray</code>, or as arrays of
     * any supported Java type. Arguments passed as Java types are converted to
     * MATLAB arrays according to default conversion rules.
     *
     * <p>M-documentation as provided by the author of the M function:
     * <pre>
     * %GETFLEN Summary of this function goes here
     * %   Detailed explanation goes here
     * </pre>
     * </p>
     * @param nargout Number of outputs to return.
     * @param rhs The inputs to the M function.
     * @return Array of length nargout containing the function outputs. Outputs
     * are returned as sub-classes of
     * <code>com.mathworks.toolbox.javabuilder.MWArray</code>. Each output array
     * should be freed by calling its <code>dispose()</code> method.
     * @throws MWException An error has occurred during the function call.
     */
    public Object[] mygetFlen(int nargout, Object... rhs) throws MWException
    {
        Object[] lhs = new Object[nargout];
        fMCR.invoke(Arrays.asList(lhs), 
                    MWMCR.getRhsCompat(rhs, sMygetFlenSignature), 
                    sMygetFlenSignature);
        return lhs;
    }
}
