import { Module } from "@nestjs/common";
import { TypeOrmModule } from '@nestjs/typeorm';
import { CategoryMapper, CategoryProfile } from "../mappers/index.mapper";
import { ContextInformationUtil } from "../utils/context.information.util";
import { BusinessResponse } from "src/dtos/response/businnes.response";
import { CategoryDocument } from "src/api/documents/Category.document";
import { CategoryController } from "src/api/controllers/Category.controller";
import { CategoryService } from "src/api/services/Category.service";
import { CategoryRepository } from "src/api/documents/contracts/Category.repository";

@Module({
    imports: [
        TypeOrmModule.forFeature([CategoryDocument])
    ],
    controllers: [CategoryController],
    providers: [CategoryService, CategoryMapper, CategoryProfile, CategoryRepository, ContextInformationUtil, BusinessResponse]
})
export class CategoryModule { }