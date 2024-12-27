from sqlalchemy import Column, Integer, String, Float, ForeignKey, create_engine
from sqlalchemy.orm import relationship, sessionmaker, declarative_base

Base = declarative_base()

class Category(Base):
    __tablename__ = 'categories'
    id = Column(Integer, primary_key=True)
    name = Column(String, nullable=False, unique=True)
    products = relationship("Product", back_populates="category", cascade="all, delete")

class Product(Base):
    __tablename__ = 'products'
    id = Column(Integer, primary_key=True)
    name = Column(String, nullable=False)
    price = Column(Float, nullable=False)
    category_id = Column(Integer, ForeignKey('categories.id', ondelete='CASCADE'))
    category = relationship("Category", back_populates="products")

engine = create_engine('sqlite:///example.db', echo=False)
Base.metadata.create_all(engine)
session = sessionmaker(bind=engine)()

# CRUD-операции
def reset_database():
    session.query(Product).delete()
    session.query(Category).delete()
    session.commit()

def create_data():
    reset_database()
    electronics = Category(name="Electronics")
    books = Category(name="Books")
    session.add_all([
        electronics,
        books,
        Product(name="Laptop", price=1200.99, category=electronics),
        Product(name="Smartphone", price=800.50, category=electronics),
        Product(name="Fiction Book", price=15.99, category=books)
    ])
    session.commit()

def create_data():
    def get_or_create_category(name):
        category = session.query(Category).filter_by(name=name).first()
        if not category:
            category = Category(name=name)
            session.add(category)
        return category

    electronics = get_or_create_category("Electronics")
    books = get_or_create_category("Books")

    session.add_all([
        Product(name="Laptop", price=1200.99, category=electronics),
        Product(name="Smartphone", price=800.50, category=electronics),
        Product(name="Fiction Book", price=15.99, category=books)
    ])
    session.commit()

def read_products_by_category(category_name):
    category = session.query(Category).filter_by(name=category_name).first()
    if category:
        print(f"Products in '{category_name}': {[product.name for product in category.products]}")
    else:
        print(f"Category '{category_name}' not found.")

def update_product_category(product_name, new_category_name):
    product = session.query(Product).filter_by(name=product_name).first()
    new_category = session.query(Category).filter_by(name=new_category_name).first()
    if product and new_category:
        product.category = new_category
        session.commit()
        print(f"Updated '{product_name}' to category '{new_category_name}'.")

def delete_category(category_name):
    category = session.query(Category).filter_by(name=category_name).first()
    if category:
        session.delete(category)
        session.commit()
        print(f"Deleted category '{category_name}'.")

# Пример использования
if __name__ == "__main__":
    create_data()
    read_products_by_category("Electronics")
    update_product_category("Laptop", "Books")
    read_products_by_category("Books")
    delete_category("Electronics")
    read_products_by_category("Electronics")
