/* 
 * =============================================================
 * Copyright (C) 2007-2011 Edgenius (http://www.edgenius.com)
 * =============================================================
 * License Information: http://www.edgenius.com/licensing/edgenius/2.0/
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License version 2.0
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA
 *
 * http://www.gnu.org/licenses/gpl.txt
 *  
 * ****************************************************************
 */
package com.edgenius.wiki.gwt.client.widgets;

import java.util.List;

import com.edgenius.wiki.gwt.client.ElementRequester;
import com.edgenius.wiki.gwt.client.ElementRequesterCallback;
import com.edgenius.wiki.gwt.client.model.TreeItemListModel;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.TextBox;

/**
 * Only for page title by given spaceUname, in request(String) method.
 * @author Dapeng.Ni
 */
public class PageSuggestBox extends SimplePanel implements ElementRequesterCallback, HasText{
	private TextBox box = new TextBox();
	private	MultiWordSuggestOracle oracle = new MultiWordSuggestOracle();
	private SuggestBox suggest = new SuggestBox(oracle,box);
	
	private ElementRequester requester = new ElementRequester(null);
	
	public PageSuggestBox(){
		requester.addCallback(this);
		
		this.setWidget(suggest);
	}
	
	public void request(String spaceUname){
		oracle.clear();
		requester.needPageTitleList(spaceUname);
	}

	public void pageTitleList(String spaceUname, List<String> titles) {
		oracle.clear();
		oracle.addAll(titles);
	}
	public void pageTitleListRequestFailed(String errorCode) {
		oracle.clear();
		
	}

	public void addFocusHandler(FocusHandler listener) {
		box.addFocusHandler(listener);
	}
	
	public String getText() {
		return box.getText();
	}
	public void setText(String text) {
		box.setText(text);
	}
	public void setStyleName(String style){
		box.setStyleName(style);
	}
	//not need implemented
	public void spaceUnameList(List<String> spaces) {}
	public void spaceUnameListRequestFailed(String errorCode) {	}
	public void pageTree(TreeItemListModel model) {}
	public void pageTreeRequestFailed(String errorCode) {}

	/**
	 * @param b
	 */
	public void setFocus(boolean focus) {
		suggest.setFocus(true);
		
	}

}
