package org.jrebirth.presentation.ui.slides.arch;

import org.jrebirth.presentation.ui.template.AbstractTemplateModel;

/**
 * The class <strong>ArchModel</strong>.
 * 
 * @author Sébastien Bordes
 * 
 * @version $Revision: 55 $ $Author: sbordes $
 * @since $Date: 2011-10-14 19:23:59 +0200 (Fri, 14 Oct 2011) $
 */
public final class ArchModel extends AbstractTemplateModel<ArchModel, ArchView, ArchSlideStep> {

    /**
     * {@inheritDoc}
     */
    @Override
    protected ArchSlideStep[] initializeSlideStep() {
        return ArchSlideStep.values();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showSlideStep(final ArchSlideStep slideStep) {

        switch (slideStep) {

            case JVM:
                getView().showJvm();
                break;
            case JavaFXApi:
                getView().showJavaFXApi();
                break;
            case QuantumTookit:
                getView().showQuantumTookit();
                break;
            case Prism:
                getView().showPrism();
                break;
            case Java2D:
                getView().showJava2D();
                break;
            case OpenGL_D3D:
                getView().showOpenGLAndD3D();
                break;
            case GlassWindowingToolit:
                getView().showGlassWindowingToolit();
                break;
            case MediaAndWebEngine:
                getView().showMediaAndWebEngine();
                break;
            default:
        }
    }

}
