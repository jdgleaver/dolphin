package org.dolphinemu.dolphinemu.features.settings.model.view;

import org.dolphinemu.dolphinemu.features.settings.model.BooleanSetting;
import org.dolphinemu.dolphinemu.features.settings.model.Setting;

public final class CheckBoxSetting extends SettingsItem
{
  private boolean mDefaultValue;

  public CheckBoxSetting(String key, String section, int titleId, int descriptionId,
          boolean defaultValue, Setting setting)
  {
    super(key, section, setting, titleId, descriptionId);
    mDefaultValue = defaultValue;
  }

  public boolean isChecked()
  {
    if (getSetting() == null || !(getSetting() instanceof BooleanSetting))
    {
      return mDefaultValue;
    }

    BooleanSetting setting = (BooleanSetting) getSetting();
    return setting.getValue();
  }

  /**
   * Write a value to the backing boolean. If that boolean was previously null,
   * initializes a new one and returns it, so it can be added to the Hashmap.
   *
   * @param checked Pretty self explanatory.
   * @return null if overwritten successfully; otherwise, a newly created BooleanSetting.
   */
  public BooleanSetting setChecked(boolean checked)
  {
    if (getSetting() == null || !(getSetting() instanceof BooleanSetting))
    {
      BooleanSetting setting = new BooleanSetting(getKey(), getSection(), checked);
      setSetting(setting);
      return setting;
    }
    else
    {
      BooleanSetting setting = (BooleanSetting) getSetting();
      setting.setValue(checked);
      return null;
    }
  }

  @Override
  public int getType()
  {
    return TYPE_CHECKBOX;
  }
}