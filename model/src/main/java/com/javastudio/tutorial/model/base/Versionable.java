package com.javastudio.tutorial.model.base;

        import javax.persistence.Basic;
        import javax.persistence.Column;
        import javax.persistence.DiscriminatorColumn;
        import javax.persistence.Inheritance;
        import javax.persistence.InheritanceType;
        import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "VERSIONABLE_TYPE")
public abstract class Versionable extends AuditedObject {

    @Column(name = "dirty")
    @Basic(optional = false)
    private boolean dirty = false;

    public boolean getDirty() {
        return this.dirty;
    }

    /**
     * @param dirty the dirty to set
     */
    public void setDirty(boolean dirty) {
        this.dirty = dirty;
    }

    @Override
    public void update(AuditedObject target, AuditedObject source) {
        ((Versionable) target).setDirty(((Versionable) source).getDirty());
        super.update(target, source);
    }
}