package com.laudandjolynn.test.annotation;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic.Kind;

/**
 * @author: Laud
 * @email: htd0324@gmail.com
 * @date: 2013-3-27 上午9:17:53
 * @copyright: www.armisi.com.cn
 */
@SupportedAnnotationTypes("com.laudandjolynn.test.annotation.AgreementField")
public class AgreementAnnotationProcessor extends AbstractProcessor {

	@Override
	public SourceVersion getSupportedSourceVersion() {
		return SourceVersion.latestSupported();
	}

	@Override
	public boolean process(Set<? extends TypeElement> annotations,
			RoundEnvironment roundEnv) {
		Messager messager = processingEnv.getMessager();
		for (TypeElement te : annotations) {
			for (Element e : roundEnv.getElementsAnnotatedWith(te)) {
				AgreementField af = e.getAnnotation(AgreementField.class);
				messager.printMessage(Kind.NOTE, af.agreementName());
			}
		}
		return true;
	}

}
