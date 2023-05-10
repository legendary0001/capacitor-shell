import Foundation

@objc public class shell: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}
