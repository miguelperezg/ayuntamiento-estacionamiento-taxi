/*
 * JasperReports - Free Java Reporting Library.
 * Copyright (C) 2001 - 2014 TIBCO Software Inc. All rights reserved.
 * http://www.jaspersoft.com
 *
 * Unless you have purchased a commercial license agreement from Jaspersoft,
 * the following license terms apply:
 *
 * This program is part of JasperReports.
 *
 * JasperReports is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JasperReports is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with JasperReports. If not, see <http://www.gnu.org/licenses/>.
 */
package net.sf.jasperreports.engine.export.ooxml;

import java.io.Writer;
import java.util.Locale;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRRuntimeException;
import net.sf.jasperreports.engine.JasperReportsContext;
import net.sf.jasperreports.engine.export.JRExporterGridCell;
import net.sf.jasperreports.engine.export.data.BooleanTextValue;
import net.sf.jasperreports.engine.export.data.DateTextValue;
import net.sf.jasperreports.engine.export.data.NumberTextValue;
import net.sf.jasperreports.engine.export.data.StringTextValue;
import net.sf.jasperreports.engine.export.data.TextValue;
import net.sf.jasperreports.engine.export.data.TextValueHandler;
import net.sf.jasperreports.engine.type.VerticalAlignEnum;


/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id: XlsxCellHelper.java 7197 2014-08-27 11:59:50Z teodord $
 */
public class XlsxCellHelper extends BaseHelper
{
	/**
	 *
	 */
	private static final String VERTICAL_ALIGN_TOP = "top";
	private static final String VERTICAL_ALIGN_MIDDLE = "center";
	private static final String VERTICAL_ALIGN_BOTTOM = "bottom";
	
	/**
	 *
	 */
	private XlsxStyleHelper styleHelper;
//	private XlsxBorderHelper borderHelper;
	
	private final TypeTextValueHandler textValueHandler = new TypeTextValueHandler();
	
	/**
	 *
	 */
	public XlsxCellHelper(
		JasperReportsContext jasperReportsContext,
		Writer writer,
		XlsxStyleHelper styleHelper
		)
	{
		super(jasperReportsContext, writer);
		
		this.styleHelper = styleHelper;
//		borderHelper = new XlsxBorderHelper(writer);
	}

	/**
	 * 
	 *
	public XlsxBorderHelper getBorderHelper() 
	{
		return borderHelper;
	}

	/**
	 *
	 */
	public void exportHeader(
		JRExporterGridCell gridCell,
		int rowIndex,
		int colIndex 
		) 
	{
		exportHeader(gridCell, rowIndex, colIndex, null, null, null, true, false, false);
	}

	/**
	 *
	 */
	public void exportHeader(
		JRExporterGridCell gridCell,
		int rowIndex,
		int colIndex, 
		TextValue textValue,
		String pattern,
		Locale locale,
		boolean isWrapText,
		boolean isHidden,
		boolean isLocked
		) 
	{
		try
		{
			if (textValue != null)
			{
				textValue.handle(textValueHandler);
			}
			else
			{
				textValueHandler.handle((StringTextValue)null);
			}
		}
		catch (JRException e)
		{
			throw new JRRuntimeException(e);
		}

		write("  <c r=\"" + getColumIndexLetter(colIndex) + (rowIndex + 1) + "\" s=\"" + styleHelper.getCellStyle(gridCell, pattern, locale, isWrapText, isHidden, isLocked) + "\"");
		String type = textValueHandler.getType();
		if (type != null)
		{
			write(" t=\"" + type + "\"");
		}
		write(">");
	}

	/**
	 *
	 */
	public void exportFooter() 
	{
		write("</c>");
	}

	
	/**
	 *
	 */
	public static String getVerticalAlignment(VerticalAlignEnum verticalAlignment)
	{
		if (verticalAlignment != null)
		{
			switch (verticalAlignment)
			{
				case BOTTOM :
					return VERTICAL_ALIGN_BOTTOM;
				case MIDDLE :
					return VERTICAL_ALIGN_MIDDLE;
				case TOP :
				default :
					return VERTICAL_ALIGN_TOP;
			}
		}
		return null;
	}
	
	
	/**
	 *
	 */
	public static String getColumIndexLetter(int colIndex)
	{
		int intFirstLetter = ((colIndex) / 676) + 64;
		int intSecondLetter = ((colIndex % 676) / 26) + 64;
		int intThirdLetter = (colIndex % 26) + 65;
		
		char firstLetter = (intFirstLetter > 64) ? (char)intFirstLetter : ' ';
		char secondLetter = (intSecondLetter > 64) ? (char)intSecondLetter : ' ';
		char thirdLetter = (char)intThirdLetter;
		
		return ("" + firstLetter + secondLetter + thirdLetter).trim();
	}


}

class TypeTextValueHandler implements TextValueHandler 
{
	private String type;
	
	TypeTextValueHandler(){
	}
	
	public void handle(BooleanTextValue textValue) throws JRException {
		type = "b";
	}
	
	public void handle(DateTextValue textValue) throws JRException {
		type = null;//"d"; //mantis #5192 : invalid file in ms office 2010
	}
	
	public void handle(NumberTextValue textValue) throws JRException {
		type = "n";
	}
	
	public void handle(StringTextValue textValue) throws JRException {
		type = "inlineStr";
	}
	
	public String getType()
	{
		return type;
	}
}
