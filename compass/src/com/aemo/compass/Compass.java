package com.aemo.compass;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.common.PropertyTypeConstants;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.AndroidViewComponent;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.redinput.compassview.CompassView;


public class Compass extends AndroidNonvisibleComponent {

  private Context context;
  private CompassView compassView;
  private int BgColor = Color.YELLOW;
  private int LineColor = Color.RED;
  private int MarkerColor = Color.BLACK;
  private int TextColor = Color.WHITE;
  private boolean ShowMarker = false;
  private int TextSize = 37;
  private float RangeDegrees = 270;


  public Compass(ComponentContainer container) {
    super(container.$form());
    context = container.$context();
  }

  @SimpleFunction
  public void AddToView(AndroidViewComponent component,float degree,boolean animation){
    ViewGroup vg = (ViewGroup) component.getView();
    vg.addView(new CompassView(context,null));
    compassView.setDegrees(degree,animation);
    compassView.setOnCompassDragListener(new CompassView.OnCompassDragListener() {
      @Override
      public void onCompassDragListener(float value) {
        onCompassDrag(value);
      }
    });
  }

  @SimpleFunction
  public float Degrees(){
    return compassView.getDegrees();
  }

  /////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////
  @SimpleProperty
  @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_COLOR,defaultValue = "#FEEA3BFF")
  public void SetBgColor(int bgColor){
    BgColor = bgColor;
    compassView.setBackgroundColor(bgColor);
  }
  @SimpleProperty
  public int GetBgColor(){
    return BgColor;
  }
  //////////////////////////////////////////////////////////

  @SimpleProperty
  @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_COLOR,defaultValue = "#F44336FF")
  public void SetLineColor(int lnColor){
    LineColor = lnColor;
    compassView.setLineColor(lnColor);
  }
  @SimpleProperty
  public int GetLineColor(){
    return LineColor;
  }
  ////////////////////////////////////////////////////////
  @SimpleProperty
  @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_COLOR,defaultValue = "#000000FF")
  public void SetMarkerColor(int mkColor){
    MarkerColor = mkColor;
    compassView.setMarkerColor(mkColor);
  }
  @SimpleProperty
  public int GetMarkerColor(){
    return MarkerColor;
  }
  /////////////////////////////////////////////////////
  @SimpleProperty
  @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_COLOR,defaultValue = "#FFFFFFFF")
  public void SetTextColor(int txtColor){
    TextColor = txtColor;
    compassView.setTextColor(txtColor);
  }
  @SimpleProperty
  public int TextColor(){
    return TextColor;
  }
  /////////////////////////////////////
  @SimpleProperty
  @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_BOOLEAN,defaultValue = "false")
  public void SetShowMarker(boolean mkShow){
    ShowMarker = mkShow;
    compassView.setShowMarker(mkShow);
  }
  @SimpleProperty
  public boolean GetShowMarker(){
    return ShowMarker;
  }
  /////////////////////////
  @SimpleProperty
  @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_INTEGER,defaultValue = "37")
  public void SetTextSize(int txtSize){
    TextSize = txtSize;
    compassView.setTextSize(txtSize);
  }
  @SimpleProperty
  public int GetTextSize(){
    return TextSize;
  }
  ////////////////////////////////

  @SimpleProperty
  @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_FLOAT,defaultValue = "270")
  public void SetRangeDegrees(float rDegrees){
    RangeDegrees = rDegrees;
    compassView.setRangeDegrees(rDegrees);
  }
  @SimpleProperty
  public float GetRangeDegrees(){
    return RangeDegrees;
  }
  //////////////////////////////////////////////////
  /////////////////////////////////////////////////

  @SimpleEvent
  public void onCompassDrag(float value) {
    EventDispatcher.dispatchEvent(this, "onCompassDrag", value);
  }
  ///////////////////////////////////////////////

}
