package com.laudandjolynn.test.gearman;

import org.gearman.Gearman;
import org.gearman.GearmanFunction;
import org.gearman.GearmanFunctionCallback;
import org.gearman.GearmanServer;
import org.gearman.GearmanWorker;

/**
 * @author: Laud
 * @email: htd0324@gmail.com
 * @date: 2013-2-5 上午9:25:15
 * @copyright: www.armisi.com.cn
 */
public class EchoWorker2 implements GearmanFunction {
	/** The echo function name */
	public static final String ECHO_FUNCTION_NAME = "echo";

	/** The host address of the job server */
	public static final String ECHO_HOST = "192.168.1.123";

	/** The port number the job server is listening on */
	public static final int ECHO_PORT = 4730;

	public static void main(String... args) {

		/*
		 * Create a Gearman instance
		 */
		Gearman gearman = Gearman.createGearman();

		/*
		 * Create the job server object. This call creates an object represents
		 * a remote job server.
		 * 
		 * Parameter 1: the host address of the job server. Parameter 2: the
		 * port number the job server is listening on.
		 * 
		 * A job server receives jobs from clients and distributes them to
		 * registered workers.
		 */
		GearmanServer server = gearman.createGearmanServer(
				EchoWorker2.ECHO_HOST, EchoWorker2.ECHO_PORT);

		/*
		 * Create a gearman worker. The worker poll jobs from the server and
		 * executes the corresponding GearmanFunction
		 */
		GearmanWorker worker = gearman.createGearmanWorker();

		/*
		 * Tell the worker how to perform the echo function
		 */
		worker.addFunction(EchoWorker2.ECHO_FUNCTION_NAME, new EchoWorker2());

		/*
		 * Tell the worker that it may communicate with the this job server
		 */
		worker.addServer(server);
	}

	@Override
	public byte[] work(String function, byte[] data,
			GearmanFunctionCallback callback) throws Exception {

		/*
		 * The work method performs the gearman function. In this case, the echo
		 * function simply returns the data it received
		 */

		return data;
	}
}
