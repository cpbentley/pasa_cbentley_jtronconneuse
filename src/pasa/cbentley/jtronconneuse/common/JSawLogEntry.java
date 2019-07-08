package pasa.cbentley.jtronconneuse.common;

import pasa.cbentley.core.src4.logging.DLogEntry;
import pasa.cbentley.core.src4.logging.IStringable;

/**
 * The class that will be sent over the network.
 * 
 * the {@link DLogEntry} class is not valid because the {@link IStringable} is no more
 * @author Charles Bentley
 *
 */
public class JSawLogEntry {

   private String msg;

   private int    tagID;

   /**
    * Tag string, for the Log message.
    * <li> Event
    * <li> init
    * <li> ...
    */
   private String tagString;

   private String stringableFull;

   public String getMsg() {
      return msg;
   }

   public void setMsg(String msg) {
      this.msg = msg;
   }

   public int getTagID() {
      return tagID;
   }

   public void setTagID(int tagID) {
      this.tagID = tagID;
   }

   public String getTagString() {
      return tagString;
   }

   public void setTagString(String tagString) {
      this.tagString = tagString;
   }

   public String getThreadName() {
      return threadName;
   }

   public void setThreadName(String threadName) {
      this.threadName = threadName;
   }

   public String getClassSimpleName() {
      return classSimpleName;
   }

   public void setClassSimpleName(String classSimpleName) {
      this.classSimpleName = classSimpleName;
   }

   public String getClassFullName() {
      return classFullName;
   }

   public void setClassFullName(String classFullName) {
      this.classFullName = classFullName;
   }

   public String getMethodName() {
      return methodName;
   }

   public void setMethodName(String methodName) {
      this.methodName = methodName;
   }

   public int getDevFlags() {
      return devFlags;
   }

   public void setDevFlags(int devFlags) {
      this.devFlags = devFlags;
   }

   private String stringable1Line;

   private String threadName;

   private String classSimpleName;

   private String classFullName;

   private String methodName;

   private int    devFlags;

   public String getStringable1Line() {
      return stringable1Line;
   }

   public void setStringable1Line(String stringable1Line) {
      this.stringable1Line = stringable1Line;
   }

   public String getStringableFull() {
      return stringableFull;
   }

   public void setStringableFull(String stringableFull) {
      this.stringableFull = stringableFull;
   }

}
