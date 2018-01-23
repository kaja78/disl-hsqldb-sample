package org.disl.sample.scripts

@groovy.transform.BaseScript(org.disl.workflow.DislScript)
import org.disl.util.wiki.WikiHelper

WikiHelper wikiHelper=new WikiHelper()

wikiHelper.wikiRootDir=System.getProperty('wiki.root.dir','build/wiki')
wikiHelper.addRootPackage('org.disl.sample')
wikiHelper.generateWiki()