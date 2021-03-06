/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

public class AppendingProcessor implements Processor {
    private String suffixString;

    public AppendingProcessor() {
        this("+output");
    }

    public AppendingProcessor(String suffix) {
        suffixString = suffix;
    }

    public void setSuffixString(String suffix) {
        suffixString = suffix;
    }

    @Override
    public void process(Exchange exchange) {
        // lets transform the IN message
        Message in = exchange.getIn();
        String body = in.getBody(String.class);
        in.setBody(body + suffixString);
    }

}
