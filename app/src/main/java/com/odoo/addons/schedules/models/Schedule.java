/**
 * Odoo, Open Source Management Solution
 * Copyright (C) 2012-today Odoo SA (<http:www.odoo.com>)
 * <p/>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version
 * <p/>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details
 * <p/>
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http:www.gnu.org/licenses/>
 * <p/>
 * Created on 30/12/14 4:00 PM
 */
package com.odoo.addons.schedules.models;

import android.content.Context;
import android.net.Uri;

import com.odoo.App;
import com.odoo.base.addons.res.ResPartner;
import com.odoo.core.orm.OModel;
import com.odoo.core.orm.fields.OColumn;
import com.odoo.core.orm.fields.types.ODate;
import com.odoo.core.orm.fields.types.OFloat;
import com.odoo.core.orm.fields.types.OVarchar;
import com.odoo.core.support.OUser;

public class Schedule extends OModel {
    public static final String AUTHORITY = "com.odoo.core.im.provider.content.sync.im_schedule";

    OColumn name = new OColumn("Name", OVarchar.class).setSize(100).setRequired();
    OColumn customer_id = new OColumn("Customer", ResPartner.class, OColumn.RelationType.ManyToOne);
    OColumn seller_id = new OColumn("Seller", ResPartner.class, OColumn.RelationType.ManyToOne);
    OColumn latitude = new OColumn("Latitude", OFloat.class);
    OColumn longitude = new OColumn("Longitude", OFloat.class);
    OColumn date = new OColumn("Date", ODate.class);

    public Schedule(Context context, OUser user) {
        super(context, "im.schedule", user);
    }

    @Override
    public Uri uri() {
        return buildURI(AUTHORITY);
    }

}
