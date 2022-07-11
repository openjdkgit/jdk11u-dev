/*
 * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
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
 *
 * @summary converted from VM Testbase nsk/jvmti/ResourceExhausted/resexhausted001.
 * VM Testbase keywords: [jpda, jvmti, noras, vm6, nonconcurrent, quarantine, exclude]
 * VM Testbase comments: 7013634
 * VM Testbase readme:
 * Description
 *      Test verifies that ResourceExhausted JVMTI event is generated for
 *      too many threads OOME by creating threads.
 * Comments
 *      CR 6465063
 *
 * @library /vmTestbase
 *          /test/lib
 * @run driver jdk.test.lib.FileInstaller . .
 * @run main/othervm/native/timeout=240
 *      -agentlib:resexhausted=-waittime=5
 *      -XX:-UseGCOverheadLimit
 *      nsk.jvmti.ResourceExhausted.resexhausted001
 *      -stressTime 220
 */

