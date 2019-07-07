package com.javastudio.tutorial.jsf.component;

import javax.el.ELContext;
import javax.faces.FacesException;
import javax.faces.application.Application;
import javax.faces.application.Resource;
import javax.faces.component.UIComponent;
import javax.faces.component.UIPanel;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.Facelet;
import javax.faces.view.facelets.FaceletContext;
import java.io.IOException;

public class FacesComponent {
    public static void includeCompositeComponentAndSetValueExpression(UIComponent parent, String libraryName, String resourceName, String id) {
        // Prepare.
        FacesContext context = FacesContext.getCurrentInstance();
        Application application = context.getApplication();
        FaceletContext faceletContext = (FaceletContext) context.getAttributes().get(FaceletContext.FACELET_CONTEXT_KEY);

        // This basically creates <ui:component> based on <composite:interface>.
        Resource resource = application.getResourceHandler().createResource(resourceName, libraryName);
        UIComponent composite = application.createComponent(context, resource);

        composite.setValueExpression("title", context.getApplication().getExpressionFactory().createValueExpression(context.getELContext(), "Select a user from a list", String.class));
        // composite.setValueExpression();

        composite.setId(id); // Mandatory for the case composite is part of UIForm! Otherwise JSF can't find inputs.

        // This basically creates <composite:implementation>.
        UIComponent implementation = application.createComponent(UIPanel.COMPONENT_TYPE);
        implementation.setRendererType("javax.faces.Group");
        composite.getFacets().put(UIComponent.COMPOSITE_FACET_NAME, implementation);

        // Now include the composite component file in the given parent.
        parent.getChildren().add(composite);
        parent.pushComponentToEL(context, composite); // This makes #{cc} available.
        try {
            faceletContext.includeFacelet(implementation, resource.getURL());
        } catch (IOException e) {
            throw new FacesException(e);
        } finally {
            parent.popComponentFromEL(context);
        }
    }

    /**
     * https://stackoverflow.com/questions/5370184/how-to-programmatically-or-dynamically-create-a-composite-component-in-jsf-2/15884546#15884546
     * @param parent
     * @param libraryName
     * @param resourceName
     * @param id
     */
    public static void includeCompositeComponent(UIComponent parent, String libraryName, String resourceName, String id) {
        // Prepare.
        FacesContext context = FacesContext.getCurrentInstance();
        Application application = context.getApplication();
        FaceletContext faceletContext = (FaceletContext) context.getAttributes().get(FaceletContext.FACELET_CONTEXT_KEY);

        // This basically creates <ui:component> based on <composite:interface>.
        Resource resource = application.getResourceHandler().createResource(resourceName, libraryName);
        UIComponent composite = application.createComponent(context, resource);
        composite.setId(id); // Mandatory for the case composite is part of UIForm! Otherwise JSF can't find inputs.

        // This basically creates <composite:implementation>.
        UIComponent implementation = application.createComponent(UIPanel.COMPONENT_TYPE);
        implementation.setRendererType("javax.faces.Group");
        composite.getFacets().put(UIComponent.COMPOSITE_FACET_NAME, implementation);

        // Now include the composite component file in the given parent.
        parent.getChildren().add(composite);
        parent.pushComponentToEL(context, composite); // This makes #{cc} available.
        try {
            faceletContext.includeFacelet(implementation, resource.getURL());
        } catch (IOException e) {
            throw new FacesException(e);
        } finally {
            parent.popComponentFromEL(context);
        }
    }

    public static void includeCompositeComponent1(UIComponent parent, String taglibURI, String tagName, String id) {
        FacesContext context = FacesContext.getCurrentInstance();
        UIComponent composite = context.getApplication().getViewHandler()
                .getViewDeclarationLanguage(context, context.getViewRoot().getViewId())
                .createComponent(context, taglibURI, tagName, null);
        composite.setId(id);
        parent.getChildren().add(composite);
    }

    /*
    public UIComponent addWidget( UIComponent parent, String widget ) {
        UIComponent cc = null;
        UIComponent facetComponent = null;
        FacesContext ctx = FacesContext.getCurrentInstance();
        Resource resource = ctx.getApplication().getResourceHandler().createResource( widget + ".xhtml", "widgets" );
        FaceletFactory faceletFactory = (FaceletFactory) RequestStateManager.get( ctx, RequestStateManager.FACELET_FACTORY );

        // create the facelet component
        cc = ctx.getApplication().createComponent( ctx, resource );

        // create the component to be populated by the facelet
        facetComponent = ctx.getApplication().createComponent( UIPanel.COMPONENT_TYPE );
        facetComponent.setRendererType( "javax.faces.Group" );

        // set the facelet's parent
        cc.getFacets().put( UIComponent.COMPOSITE_FACET_NAME, facetComponent );

        // populate the facetComponent
        try {
            Facelet facelet = faceletFactory.getFacelet( resource.getURL() );
            facelet.apply( ctx, facetComponent );
        } catch ( IOException e ) {
            e.printStackTrace();
        }

        // finally add the facetComponent to the given parent
        parent.getChildren().add( cc );

        return cc;
    }
    */

}
