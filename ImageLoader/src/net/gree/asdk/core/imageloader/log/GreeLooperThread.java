/*
 * Copyright 2012 GREE, Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *    http://www.apache.org/licenses/LICENSE-2.0
 *    
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.gree.asdk.core.imageloader.log;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class GreeLooperThread extends Thread {
  private Handler mHandler;
  public Handler getHandler() {
    return mHandler;
  }

  protected void handleGreeMessage(Message msg) {}

  public void run() {
    Looper.prepare();
    mHandler = new Handler() {
      public void handleMessage(Message msg) {
        handleGreeMessage(msg);
      }
    };
    Looper.loop();
  }
  public Handler startAndGetHandler() {
    super.start();
    return mHandler;
  }
}
