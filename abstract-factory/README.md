README.md
参与者：

AbstractFactory：抽象工厂。抽象工厂定义了一个接口，所有的具体工厂都必须实现此接口，这个接口包含了一组方法用来生产产品。

ConcreteFactory：具体工厂。具体工厂是用于生产不同产品族。要创建一个产品，客户只需要使用其中一个工厂完全不需要实例化任何产品对象。

AbstractProduct：抽象产品。这是一个产品家族，每一个具体工厂都能够生产一整组产品。

Product：具体产品