/*
 * Copyright (c) 2012, 2025, Oracle and/or its affiliates. All rights reserved.
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
 * @bug 7021614 8273244 8352249
 * @summary extend com.sun.source API to support parsing javadoc comments
 * @modules jdk.compiler/com.sun.tools.javac.api
 *          jdk.compiler/com.sun.tools.javac.file
 *          jdk.compiler/com.sun.tools.javac.tree
 *          jdk.compiler/com.sun.tools.javac.util
 * @build DocCommentTester
 * @run main DocCommentTester SerialTest.java
 */

class SerialTest {
    /**
     * @serial include
     */
    void include() { }
/*
DocComment[DOC_COMMENT, pos:0
  firstSentence: empty
  body: empty
  block tags: 1
    Serial[SERIAL, pos:0
      description: 1
        Text[TEXT, pos:8, include]
    ]
]
*/

    /**
     * @serial exclude
     */
    void exclude() { }
/*
DocComment[DOC_COMMENT, pos:0
  firstSentence: empty
  body: empty
  block tags: 1
    Serial[SERIAL, pos:0
      description: 1
        Text[TEXT, pos:8, exclude]
    ]
]
*/

    /**
     * @serial description
     */
    void description() { }
/*
DocComment[DOC_COMMENT, pos:0
  firstSentence: empty
  body: empty
  block tags: 1
    Serial[SERIAL, pos:0
      description: 1
        Text[TEXT, pos:8, description]
    ]
]
*/

    /**
     * @serial
     */
    void empty() { }
/*
DocComment[DOC_COMMENT, pos:0
  firstSentence: empty
  body: empty
  block tags: 1
    Serial[SERIAL, pos:0
      description: empty
    ]
]
*/

}

