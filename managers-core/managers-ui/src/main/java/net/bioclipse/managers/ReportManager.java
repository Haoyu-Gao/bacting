/* Copyright (c) 2015,2020  Egon Willighagen <egon.willighagen@gmail.com>
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contact: http://www.bioclipse.net/
 */
package net.bioclipse.managers;

import net.bioclipse.report.data.Report;

import java.util.Collections;
import java.util.List;

import io.github.egonw.bacting.IBactingManager;
import net.bioclipse.managers.report.serializer.MarkdownSerializer;
import net.bioclipse.report.data.IReport;
import net.bioclipse.report.serializer.HTMLSerializer;

/**
 * Bioclipse manager providing reporting functionality. Reports are
 * created as {@link IReport} which can be serialized as HTML. 
 */
public class ReportManager implements IBactingManager {

	private String workspaceRoot;

    /**
     * Creates a new {@link ReportManager}.
     *
     * @param workspaceRoot location of the workspace, e.g. "."
     */
	public ReportManager(String workspaceRoot) {
		this.workspaceRoot = workspaceRoot;
	}

    /**
     * Gives a short one word name of the manager used as variable name when
     * scripting.
     */
    public String getManagerName() {
        return "report";
    }

    /**
     * Creates a new {@link IReport} object.
     * 
     * @return an empty {@link IReport}
     */
    public IReport createReport() {
    	return new Report();
    }

    /**
     * Serializes the content of the given report into HTML.
     *
     * @param report an {@link IReport}
     * @return       a HTML document as {@link String}
     */
    public String asHTML(IReport report) {
    	return new HTMLSerializer().serialize(report);
    }

    /**
     * Serializes the content of the given report into Markdown.
     *
     * @param report an {@link IReport}
     * @return       a Markdown document as {@link String}
     */
    public String asMarkdown(IReport report) {
        return new MarkdownSerializer().serialize(report);
    }

	@Override
	public List<String> doi() {
		return Collections.emptyList();
	}

}
