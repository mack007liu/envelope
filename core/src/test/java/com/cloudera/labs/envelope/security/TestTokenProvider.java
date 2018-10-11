/**
 * Licensed to Cloudera, Inc. under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. Cloudera, Inc. licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cloudera.labs.envelope.security;

import org.apache.hadoop.security.token.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestTokenProvider implements TokenProvider {

  private static final Logger LOG = LoggerFactory.getLogger(TestTokenProvider.class);

  private int generation = 0;

  @Override
  public Token obtainToken() {
    LOG.debug("Creating new token with generation: {}", generation);
    return SecurityUtils.createToken(new byte[0], generation++);
  }

  @Override
  public long getRenewalIntervalMillis() {
    return 500;
  }

  @Override
  public String getAlias() {
    return "test-provider";
  }

  public int getGeneration() {
    return generation;
  }

}
