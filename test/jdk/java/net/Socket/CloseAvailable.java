/*
 * Copyright (c) 1998, 2018, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

/*
 * @test
 * @bug 4091859
 * @library /test/lib
 * @summary Test Socket.available()
 * @run main CloseAvailable
 * @run main/othervm -Djava.net.preferIPv4Stack=true CloseAvailable
 */

import java.net.*;
import java.io.*;
import jdk.test.lib.net.IPSupport;

public class CloseAvailable implements Runnable {
    static ServerSocket ss;
    static InetAddress addr;
    static int port;

    public static void main(String[] args) throws Exception {
        IPSupport.throwSkippedExceptionIfNonOperational();

        boolean error = true;
        addr = InetAddress.getLocalHost();
        ss = new ServerSocket(0);
        port = ss.getLocalPort();

        Thread t = new Thread(new CloseAvailable());
        t.start();

        Socket  soc = ss.accept();
        ss.close();

        DataInputStream is = new DataInputStream(soc.getInputStream());
        is.close();

        try {
            is.available();
        }
        catch (IOException ex) {
            error = false;
        }
        if (error)
            throw new RuntimeException("Available() can be called after stream closed.");
    }

    public void run() {
        try {
            Socket s = new Socket(addr, port);
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
