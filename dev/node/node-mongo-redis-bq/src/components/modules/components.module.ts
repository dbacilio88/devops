import { Module } from "@nestjs/common";
import { PersonModule } from "./person.module";
import { CategoryModule } from "./category.module";
import { SpecialtyModule } from "./specialty.module";
import { QuestionModule } from "./question.module";
import { AnswerModule } from "./answer.module";


const components = [
    PersonModule,
    CategoryModule,
    SpecialtyModule,
    QuestionModule,
    AnswerModule
]


@Module({
    imports: [
        ...components
    ],
    exports: [
        ...components
    ]
})
export class ComponentsModule { }